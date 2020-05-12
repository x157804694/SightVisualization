package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.SightCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SightCategoryMapper {
    SightCategory findOneBySightId(@Param("sightCategory") SightCategory sightCategory);
    Long updateClickNum(@Param("sightCategory") SightCategory sightCategory);
    List<SightCategory> findSightRandomlyByType(Integer type);
    List<SightCategory> findSightRandomly();
}
