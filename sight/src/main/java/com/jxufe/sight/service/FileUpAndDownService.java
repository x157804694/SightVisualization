package com.jxufe.sight.service;

import com.jxufe.sight.exception.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUpAndDownService {
    Map<String, Object> uploadPicture(MultipartFile file) throws ServiceException;
}
