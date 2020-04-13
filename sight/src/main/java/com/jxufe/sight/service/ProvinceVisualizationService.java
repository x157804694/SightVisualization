package com.jxufe.sight.service;

import com.jxufe.sight.vo.ProvinceVisualizationVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ProvinceVisualizationService {
    List<ProvinceVisualizationVO> getProvinceSaleCountTop10(String province);
    List<HashMap<String,Integer>> getPriceOfSight(String province);
    List<HashMap<String,Integer>> getCitySightNum(String province);
    List<HashMap<String, String>> getStarOfSight(String province);
    List<HashMap<String, ArrayList>> getCityCoord(String province);
    List<HashMap<String, String>> getCitySightNumTop5(String province);
    Integer getSumSaleCount(String province);
    List<HashMap<String, Integer>> getSumSaleCountGroupByStar(String province);
    List<HashMap<String, Integer>> getCitySaleCountTop5(String province);
}
