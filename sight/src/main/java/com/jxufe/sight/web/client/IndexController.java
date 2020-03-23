package com.jxufe.sight.web.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(HttpServletRequest request){
        //请求转发前，添加index参数，标识这是一个首页请求
        request.setAttribute("index",true);
        return "forward:/querySights/全国";
    }
}
