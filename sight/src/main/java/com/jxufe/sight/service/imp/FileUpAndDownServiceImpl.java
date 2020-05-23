package com.jxufe.sight.service.imp;

import com.jxufe.sight.bean.UploadPathManagement;
import com.jxufe.sight.exception.ServiceException;
import com.jxufe.sight.service.FileUpAndDownService;
import com.jxufe.sight.service.IStatusMessage;
import com.jxufe.sight.vo.MessageProperties;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUpAndDownServiceImpl implements FileUpAndDownService {

    @Autowired
    private MessageProperties config; //用来获取file-message.properties配置文件中的信息
    @Autowired
    private UploadPathManagement uploadPathManagement;

    @Override
    public Map<String, Object> uploadPicture(MultipartFile file) throws ServiceException {
        try {
            Map<String, Object> resMap = new HashMap<>();
            String[] IMAGE_TYPE = config.getImageType().split(",");
            String path = null;
            boolean flag = false;
            for (String type : IMAGE_TYPE) {
                if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                resMap.put("result", IStatusMessage.SystemStatus.SUCCESS.getMessage());
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                // 获得文件类型
                String fileType = file.getContentType();
                // 获得文件后缀名称
                String imageName = fileType.substring(fileType.indexOf("/") + 1);
                // 原名称
                String oldFileName = file.getOriginalFilename();
                // 新名称
                String newFileName = uuid + "." + imageName;
                // 年月日文件夹
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String basedir = sdf.format(new Date());
//                System.out.println(ResourceUtils.getURL("classpath:static").getPath().substring(1));
                String travelImgsAccessBasePath=uploadPathManagement.getTravelImgsAccessPath().substring(0,uploadPathManagement.getTravelImgsAccessPath().indexOf("**"));
                String travelImgsResourceBasePath=uploadPathManagement.getTravelImgsResourcePath().substring(uploadPathManagement.getTravelImgsResourcePath().indexOf("/")+1);
                // 进行压缩(大于4M)
                if (file.getSize() > config.getFileSize()) {
                    System.out.println("压缩");
                    // 重新生成
                    String newUUID = UUID.randomUUID().toString().replaceAll("-", "");
                    newFileName = newUUID + "." + imageName;
                    //config.getUpPath();
                    //待上传的文件路径
//                    path = ResourceUtils.getURL("classpath:static").getPath().substring(1) + "/" + "images" + "/" + "travelImg" + "/" + newUUID + "." + imageName;
                    path = travelImgsResourceBasePath+ newUUID + "." + imageName;
                    path = URLDecoder.decode(path, "utf-8");
                    System.out.println("path: " + path);

                    // 如果目录不存在则创建目录
                    File oldFile = new File(path);
                    if (!oldFile.exists()) {
                        oldFile.mkdirs();
                        System.out.println("创建目录");
                    }
                    file.transferTo(oldFile);
                    // 压缩图片
                    Thumbnails.of(oldFile).scale(config.getScaleRatio()).toFile(path);
                    // 显示路径
//                    resMap.put("path", "/" + basedir + "/" + newUUID + "." + imageName);
                    resMap.put("path", travelImgsAccessBasePath + basedir + "/" + newUUID + "." + imageName);
                } else {
                    String targetFileName=uuid + "." + imageName;
                    System.out.println("未压缩");
//                    path = ResourceUtils.getURL("classpath:static").getPath().substring(1) + "/" + "images" + "/" + "travelImg" + "/" + uuid + "." + imageName;
                    path = travelImgsResourceBasePath + targetFileName;
                    path = URLDecoder.decode(path, "utf-8");
                    System.out.println("path: " + path);
                    // 如果目录不存在则创建目录
                    File uploadFile = new File(path);
                    if (!uploadFile.exists()) {
                        uploadFile.mkdirs();
                        System.out.println("创建目录");
                    }
                    file.transferTo(uploadFile);
                    // 显示路径
//                    resMap.put("path", "/" + "travelImg" + "/" + targetFileName);
                    resMap.put("path", travelImgsAccessBasePath + targetFileName);
                }
                resMap.put("oldFileName", oldFileName);
                resMap.put("newFileName", newFileName);
                //System.out.println("图片旧名称: " + oldFileName);
                //System.out.println("图片新名称: " + newFileName);
                resMap.put("fileSize", file.getSize());
            } else {
                resMap.put("result", "图片格式不正确,支持png|jpg|jpeg");
            }
            return resMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }
}
