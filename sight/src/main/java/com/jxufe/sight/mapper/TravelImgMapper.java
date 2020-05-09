package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.TravelImgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelImgMapper {
    Long savetravelImg(@Param("travelImgs") TravelImgs travelImgs);
    List<TravelImgs> findAllTravelImg(@Param("travelId") Long travelId);
}
