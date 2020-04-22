package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.ProvinceVisualizationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProvinceVisualizationMapper {
    ProvinceVisualizationVO findById(long id);
    ProvinceVisualizationVO findBySightId(String sightId);
    List<ProvinceVisualizationVO> getProvinceSaleCountTop10(@Param("province") String province);
    Integer getPriceOfSight(@Param("start") Double start,@Param("end") Double end,@Param("province") String province);
    List<HashMap<String, String>> getStarOfSight(@Param("province") String province);
    List<HashMap<String, String>> getCitySightNumTop5(@Param("province") String province);
    List<HashMap<String, ArrayList>> getCityCoord(@Param("province") String province);
    Integer getSumSaleCount(@Param("province") String province);
    List<HashMap<String, Integer>> getCitySightNum(@Param("province") String province);
    List<HashMap<String, Integer>> getSumSaleCountGroupByStar(@Param("province") String province);
    List<HashMap<String, Integer>> getCitySaleCountTop5(@Param("province") String province);
}
