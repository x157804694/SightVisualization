package com.jxufe.sight.service;

import com.github.pagehelper.PageInfo;
import com.jxufe.sight.vo.SightBasicInfoVO;

import java.util.HashMap;
import java.util.List;

public interface SightBasicInfoService {
    PageInfo<SightBasicInfoVO> findOnePage(String province, Double start, Double end, Integer order, int page, int pageSize);
    List<HashMap<String, Integer>> getCitySightNum();
    List<HashMap<String, Integer>> getDiffStarNum();
    List<HashMap<String, Integer>> getDiffStarSaleCount(Integer month);
    List<HashMap<String, Integer>> getDiffPriceRangeNum();
    List<HashMap<String, String>> getCitySightNumTop5();
    List<HashMap<String, String>> getCitySaleCountTop5(Integer month);
    List<HashMap<String,String>> getZoneSaleCount(Integer month);
    List<String> getAllProvince();
    List<SightBasicInfoVO> getSightSaleCountTop10(Integer month);
    Integer getSumSaleCount(Integer month);

}
