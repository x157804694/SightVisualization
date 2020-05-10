package com.jxufe.sight.web.client;

import com.jxufe.sight.exception.ServiceException;
import com.jxufe.sight.service.FileUpAndDownService;
import com.jxufe.sight.service.IStatusMessage;
import com.jxufe.sight.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUpAndDownService fileUpAndDownService;

    @RequestMapping(value = "/setFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setFileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                                        HttpSession session) {
        ResponseResult result = new ResponseResult();
        try {
            Map<String, Object> resultMap = upload(file);
            if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
                result.setMessage((String) resultMap.get("msg"));
                return result;
            }
            System.out.println("图片名称2: " + resultMap.get("newFileName"));
            ArrayList arrayList = new ArrayList();
            ArrayList plist = (ArrayList) session.getAttribute("list");
//            System.out.println("11111111111111111111111111111111111111111111");
            if (plist != null){
                for (int i=0;i<plist.size();i++){
                    arrayList.add(plist.get(i));
                    System.out.println("i = " + i + " " + plist.get(i));
                }
            }
            arrayList.add(resultMap.get("newFileName"));
//            System.out.println("22222222222222222222222222222222222222222222");
            session.setAttribute("list",arrayList);
            result.setData(resultMap);
        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.ERROR.getCode());
        }
        return result;
    }

    private Map<String, Object> upload(MultipartFile file) throws ServiceException {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            if (!file.isEmpty()) {
                Map<String, Object> picMap = fileUpAndDownService.uploadPicture(file);
                if (IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(picMap.get("result"))) {
                    return picMap;
                } else {
                    returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
                    returnMap.put("msg", picMap.get("result"));
                }
            } else {
                LOGGER.info(">>>>>>上传图片为空文件");
                returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
                returnMap.put("msg", IStatusMessage.SystemStatus.FILE_UPLOAD_NULL.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(IStatusMessage.SystemStatus.ERROR.getMessage());
        }
        return returnMap;
    }
}
