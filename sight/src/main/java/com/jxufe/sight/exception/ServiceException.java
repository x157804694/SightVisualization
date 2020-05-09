package com.jxufe.sight.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(Throwable throwable){
        super(throwable);
    }
    public ServiceException(String message ,Throwable throwable){
        super(message, throwable);
    }
}
