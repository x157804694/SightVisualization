package com.jxufe.sight.web.client;

import com.jxufe.sight.bean.UploadPathManagement;
import com.jxufe.sight.service.UserService;
import com.jxufe.sight.utils.StatusCodes;
import com.jxufe.sight.vo.ResponseResult;
import com.jxufe.sight.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class UserController {
    //头像访问路径
    private static final String avatarAccessPath = "/images/avatars/";
    private static final String avatarUploadPath = "/images/avatars/";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UploadPathManagement uploadPathManagement;

    @GetMapping
    public String loginPage(){
        return "client/login";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request){
        //请求转发前，添加index参数，标识这是一个首页请求
        request.setAttribute("index",true);
        return "forward:/querySights/全国";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password,
                        HttpSession session, RedirectAttributes attributes){
        UserInfoVO userInfoVo = userService.findUser(username,password);
        if (userInfoVo != null){
            userInfoVo.setPassword(null);
            session.setAttribute("user",userInfoVo);
            return "redirect:/admin/index";
        } else {
            attributes.addFlashAttribute("message","用户名或者密码错误");
            return "redirect:/admin";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String password,
                           @RequestParam String nickname,RedirectAttributes attributes){
        UserInfoVO userInfoVO = userService.findUserByName(username);
        if (userInfoVO != null){
            attributes.addFlashAttribute("message","该用户名已被注册");
            return "redirect:/admin";
        }
        UserInfoVO user = userService.addUser(username,password,nickname);
        if (user == null){
            attributes.addFlashAttribute("message","注册成功");
        }
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }

    //---------------管理用户信息--------------
    @GetMapping("/user/updatePage")
    public String updatePage(Model model){
        return "client/updateUser";
    }

    //异步请求
    @PostMapping("/user/updateAvatar")
    @ResponseBody
    public ResponseResult upload(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        ResponseResult message=new ResponseResult();
        if(!file.getContentType().startsWith("image/")){
            message.setCode(String.valueOf(StatusCodes.UPLOAD_AVARTAR__FAIL));
            message.setMessage("请上传图片");
            return message;
        }
        //解析文件后缀名
        String originFileName=file.getOriginalFilename();
        String suffix=originFileName.substring(originFileName.indexOf("."));
        //目标文件名
        String destFileName= UUID.randomUUID().toString() +suffix;
        LOGGER.info("destFileName--> {}",destFileName);
        //上传文件的路径
//        String basePath= ResourceUtils.getURL("classpath:static").getPath().substring(1);//此路径打成jar时会失效。
        String basePath=uploadPathManagement.getAvatarsResourcePath();
        LOGGER.info("basePath--> {}",basePath);
        String uploadPath=basePath.substring(basePath.indexOf("/")+1);
//        String uploadPath=basePath+avatarUploadPath;
        uploadPath= URLDecoder.decode(uploadPath,"utf-8");//解决中文路径乱码
        LOGGER.info("uploadPath--> {}",uploadPath);
        File uploadDirectory=new File(uploadPath);
        if(!uploadDirectory.exists()){
            uploadDirectory.mkdirs();
        }
        //上传的目标文件
        File targetFile=new File(uploadPath, destFileName);
        //图片访问目录
        String avatarsAccessBasePath=uploadPathManagement.getAvatarsAccessPath().substring(0,uploadPathManagement.getAvatarsAccessPath().indexOf("**"));
        LOGGER.info("target file---> {}",targetFile.getAbsolutePath());
        //上传到目标文件。本质就是IO，从file的字节输入流取出字节输出到targetFile的字节输出流中。
        if (targetFile.exists()){
            message.setCode(String.valueOf(StatusCodes.UPLOAD_AVARTAR__FAIL));
            message.setMessage("文件名冲突，请重新上传！");
        }else{
            file.transferTo(targetFile);
            message.setCode(String.valueOf(StatusCodes.UPLOAD_AVARTAR_SUCCESS));
            message.setMessage("上传成功");
            Map<String, Object> resultMap=new HashMap<>();
            resultMap.put("updateAvatarAddress",avatarsAccessBasePath+destFileName);
            message.setData(resultMap);
        }
        //更新数据库
        String username=((UserInfoVO)session.getAttribute("user")).getUsername();
        userService.updateAvatarByUsername(username,avatarsAccessBasePath+destFileName);
        //更新session中的user
        UserInfoVO selectUser=userService.findUserByName(username);
        selectUser.setPassword(null);
        session.setAttribute("user",selectUser);
        return message;
    }

    @PostMapping("/user/updateInfo")
    @ResponseBody
    public ResponseResult updateInfo(UserInfoVO userInfoVO,HttpSession session){
        System.out.println(userInfoVO.toString());
        ResponseResult message=new ResponseResult();
        //去掉两边空格
        userInfoVO.setNickname(userInfoVO.getNickname().trim());
        userInfoVO.setPassword(userInfoVO.getPassword().trim());
        //先查询nickname是否存在
        System.out.println("");
        UserInfoVO selectUser=userService.findByNickname(userInfoVO.getNickname());
        System.out.println(selectUser==null);
        if(selectUser!=null && !userInfoVO.getUsername().equals(selectUser.getUsername())){
            message.setCode(String.valueOf(StatusCodes.CHANGE_USER_INFO_FAIL));
            message.setMessage("修改失败，昵称已存在");
        }else{
            //根据username修改用户信息
            userService.updateUserByUsername(userInfoVO);
            message.setCode(String.valueOf(StatusCodes.CHANGE_USER_INFO_SUCCESS));
            message.setMessage("修改成功");
            //更新session中的user
            UserInfoVO selectUserInfo=userService.findUserByName(((UserInfoVO)session.getAttribute("user")).getUsername());
            selectUserInfo.setPassword(null);
            session.setAttribute("user",selectUserInfo);
        }
        return message;
    }
}
