package com.jxufe.sight.config;

import com.jxufe.sight.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/addVoteComment")
                .addPathPatterns("/admin/addVoteReplyComment")
                .addPathPatterns("/admin/addVoteOptionNum")
                .addPathPatterns("/admin/addTravelComment")
                .addPathPatterns("/admin/addTravelReplyComment");
    }
}
