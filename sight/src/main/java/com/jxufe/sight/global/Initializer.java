package com.jxufe.sight.global;

import com.jxufe.sight.mapper.SightBasicInfoMapper;
import com.jxufe.sight.utils.AllProvinceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;


//在项目启动成功后，做一些初始化工作
@Component
public class Initializer implements ApplicationRunner {

    private SightBasicInfoMapper mapper;

    public Initializer() {
    }

    @Autowired
    public Initializer(SightBasicInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("启动成功");
        List<String> list=mapper.getAllProvince();
        AllProvinceSet.init(list);
        System.out.println(AllProvinceSet.set.toString());
    }
}
