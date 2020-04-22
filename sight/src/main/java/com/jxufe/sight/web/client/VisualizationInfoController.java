/**
 * @Description:
 * @Package: com.jxufe.sight.web.client
 * @ClassName: SightVisualizationController
 * @Author: 徐鼎立
 * @Date: 2020/3/31 18:59
 * @version: 1.0
 * Copyright (c) 2020,All Rights Reserved.
 */
package com.jxufe.sight.web.client;

import com.alibaba.druid.support.json.JSONUtils;
import com.jxufe.sight.service.SightBasicInfoService;
import com.jxufe.sight.vo.SightBasicInfoVO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/visualization")
public class VisualizationInfoController {

    @Autowired
    SightBasicInfoService sightBasicInfoService;

    //查询城市的景区数量
    @GetMapping("/getCitySightNum")
    public String queryCitySightNum() {
        List<HashMap<String, Integer>> citySightNum = sightBasicInfoService.getCitySightNum();
        return JSONUtils.toJSONString(citySightNum);
    }

    //读取本地城市坐标
    @GetMapping("/getCityCoord")
    public String queryCityCoord() throws IOException{
        ClassPathResource geoCoordRes = new ClassPathResource("static/js/echarts/json/cityCoords.json");
        File geoCoordFile = geoCoordRes.getFile();
        String geoCoord = FileUtils.readFileToString(geoCoordFile);
        System.out.println(geoCoord);
        return geoCoord;
    }
    //查询景区月销量top10
    @GetMapping("/getSightSaleCountTop10")
    public String querySightSaleCountTop10(){
        List<SightBasicInfoVO> SightSaleCountTop10 = sightBasicInfoService.getSightSaleCountTop10();
        return JSONUtils.toJSONString(SightSaleCountTop10);
    }
    //查询本月总销量
    @GetMapping("/getSumSaleCount")
    public String getSumSaleCount(){
        int SumSaleCount = sightBasicInfoService.getSumSaleCount();
        return JSONUtils.toJSONString(SumSaleCount);
    }
    //查询不同等级景区数量
    @GetMapping("/getDiffStarNum")
    public String queryDiffStarNum(){
        List<HashMap<String, Integer>> DiffStarNum = sightBasicInfoService.getDiffStarNum();
        return JSONUtils.toJSONString(DiffStarNum);
    }
    //查询不同等级景区月销量
    @GetMapping("/getDiffStarSaleCount")
    public String getDiffStarSaleCount(){
        List<HashMap<String, Integer>> DiffStarSaleCount = sightBasicInfoService.getDiffStarSaleCount();
        return JSONUtils.toJSONString(DiffStarSaleCount);
    }
    //查询不同价格区间的景区数量
    @GetMapping("/getDiffPriceRangeNum")
    public String getDiffPriceRangeNum(){
        List<HashMap<String, Integer>> DiffPriceRangeNum = sightBasicInfoService.getDiffPriceRangeNum();
        return JSONUtils.toJSONString(DiffPriceRangeNum);
    }
    //查询景区数量前五的城市中各等级景区数量及总数
    @GetMapping("/getCitySightNumTop5")
    public String getCitySightNumTop5(){
        List<HashMap<String, String>> CitySightNumTop5 = sightBasicInfoService.getCitySightNumTop5();
        return JSONUtils.toJSONString(CitySightNumTop5);
    }
    //查询景区数量前五的城市中各等级景区数量及总数
    @GetMapping("/getCitySaleCountTop5")
    public String getCitySaleCountTop5(){
        List<HashMap<String, String>> CitySaleCountTop5 = sightBasicInfoService.getCitySaleCountTop5();
        return JSONUtils.toJSONString(CitySaleCountTop5);
    }

}
