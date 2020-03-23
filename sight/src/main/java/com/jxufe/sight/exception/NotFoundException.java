package com.jxufe.sight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//@ResponseStatus，指定抛出异常时对应的状态码！
//当抛出这个异常时，响应状态码就是404。然后会解析出404.html这个错误页面！
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{
    public static final String NOT_FOUNG_SIGHT="不能找到该景区";
    public static final String NOT_FOUNG_PROVINCE="不能找到该省份";
    public NotFoundException(String message) {
        super(message);
    }
}
