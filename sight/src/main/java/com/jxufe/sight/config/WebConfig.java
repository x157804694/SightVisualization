package com.jxufe.sight.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
//    @Autowired
//    private WordCloudProperties properties;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/CNSightVisualization").setViewName("client/CNSightVisualization");
    }

//     废弃
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("--------------资源映射如下--------------------");
//        System.out.println(properties.toString());
//        String resourceLacation="file:/"+properties.getPicturesDirectory();
//        registry.addResourceHandler(properties.getAccessPath()).addResourceLocations(resourceLacation.endsWith("/")?resourceLacation:(resourceLacation+"/"));
//    }
}
