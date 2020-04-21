package com.jxufe.sight.web.client;

import com.jxufe.sight.service.UserService;
import com.jxufe.sight.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

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
}
