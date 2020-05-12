package com.jxufe.sight.service;

import com.jxufe.sight.vo.SightCategory;

import java.util.List;

public interface SightCategoryService {
    SightCategory findOneBySightId(SightCategory sightCategory);
    Long updateClickNum(SightCategory sightCategory);
    List<SightCategory> findSightRandomlyByType(Integer type);
    List<SightCategory> findSightRandomly();
}
