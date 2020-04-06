package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.SightCommentsInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SightCommentsInfoMapper {
    SightCommentsInfoVO findContent(@Param("sightId") String sightId);
    SightCommentsInfoVO findDigitalData(@Param("sightId") String sightId);
}
