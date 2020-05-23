package com.jxufe.sight.config;

import com.jxufe.sight.bean.UploadPathManagement;
import com.jxufe.sight.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private UploadPathManagement uploadPathManagement;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/addVoteComment")
                .addPathPatterns("/admin/addVoteReplyComment")
                .addPathPatterns("/admin/addVoteOptionNum")
                .addPathPatterns("/admin/addTravelComment")
                .addPathPatterns("/admin/addTravelReplyComment")
                .addPathPatterns("/recommendation");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("-----addResourceHandlers------");
        System.out.println(uploadPathManagement.getAvatarsResourcePath());
        System.out.println(uploadPathManagement.getAvatarsAccessPath());
        System.out.println(uploadPathManagement.getTravelImgsResourcePath());
        System.out.println(uploadPathManagement.getTravelImgsAccessPath());
        registry.addResourceHandler(uploadPathManagement.getAvatarsAccessPath()).addResourceLocations(uploadPathManagement.getAvatarsResourcePath());
        registry.addResourceHandler(uploadPathManagement.getTravelImgsAccessPath()).addResourceLocations(uploadPathManagement.getTravelImgsResourcePath());
    }
}
