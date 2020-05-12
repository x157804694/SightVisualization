/**
 * @Description:
 * @Package: com.jxufe.sight.service.imp
 * @ClassName: SightCategoryServiceImpl
 * @Author: 徐鼎立
 * @Date: 2020/5/11 21:50
 * @version: 1.0
 * Copyright (c) 2020,All Rights Reserved.
 */
package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.SightCategoryMapper;
import com.jxufe.sight.service.SightCategoryService;
import com.jxufe.sight.vo.SightCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightCategoryServiceImpl implements SightCategoryService {
    @Autowired
    private SightCategoryMapper sightCategoryMapper;
    @Override
    public SightCategory findOneBySightId(SightCategory sightCategory) {
        return sightCategoryMapper.findOneBySightId(sightCategory);
    }

    @Override
    public Long updateClickNum(SightCategory sightCategory) {
        SightCategory oldsightCategory = findOneBySightId(sightCategory);
        sightCategory.setClickNum(oldsightCategory.getClickNum()+1);
        System.out.println(oldsightCategory);
        return sightCategoryMapper.updateClickNum(sightCategory);
    }

    @Override
    public List<SightCategory> findSightRandomlyByType(Integer type) {
        return sightCategoryMapper.findSightRandomlyByType(type);
    }

    @Override
    public List<SightCategory> findSightRandomly() {
        return sightCategoryMapper.findSightRandomly();
    }
}
