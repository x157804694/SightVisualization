package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.TravelInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelMapper {

    Long saveTravel(@Param("travelInfoVO") TravelInfoVO travelInfoVO);
    TravelInfoVO getTravel(@Param("id") Long id);
    List<TravelInfoVO> findAllTravel();
    Long findAppreciateNum(@Param("travelId") Long travelId);
    void saveAppreciateNum(@Param("travelId") Long travelId,@Param("appreciateNum") Long appreciateNum);
}
