package com.jxufe.sight.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e,HttpServletRequest request) throws Exception{
        logger.error("抛出异常:{}",e.toString());
        e.printStackTrace();
        if(e.getClass().isAnnotationPresent(ResponseStatus.class)){
            throw e;//继续抛出异常，就会由SpringBoot来处理异常。响应状态码是该异常绑定的状态码：404
        }
        return "error/error";
    }
}
