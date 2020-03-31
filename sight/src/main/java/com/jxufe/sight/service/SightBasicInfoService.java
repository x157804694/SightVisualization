package com.jxufe.sight.service;

import com.github.pagehelper.PageInfo;
import com.jxufe.sight.vo.SightBasicInfoVO;

import java.util.HashMap;
import java.util.List;

public interface SightBasicInfoService {
    PageInfo<SightBasicInfoVO> findOnePage(String province, Double start, Double end, Integer order, int page, int pageSize);
    List<HashMap<String, Integer>> getCitySightNum();
    List<HashMap<String, Integer>> getDiffStarNum();
    List<HashMap<String, Integer>> getDiffStarSaleCount();
    List<HashMap<String, Integer>> getDiffPriceRangeNum();
    List<HashMap<String, String>> getCitySightNumTop5();
    List<HashMap<String, String>> getCitySaleCountTop5();
    List<SightBasicInfoVO> getSightSaleCountTop10();
    Integer getSumSaleCount();
}
