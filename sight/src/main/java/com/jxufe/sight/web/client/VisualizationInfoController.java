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
import org.springframework.web.bind.annotation.PathVariable;
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

    //查询城市的景区数量月销量好评数等信息
    @GetMapping("/getCitySightNum/{month}")
    public String queryCitySightNum(@PathVariable Integer month) {
        List<HashMap<String, Integer>> citySightNum = sightBasicInfoService.getCitySightNum(month);
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
    @GetMapping("/getSightSaleCountTop10/{month}")
    public String querySightSaleCountTop10(@PathVariable Integer month){
        List<SightBasicInfoVO> SightSaleCountTop10 = sightBasicInfoService.getSightSaleCountTop10(month);
        return JSONUtils.toJSONString(SightSaleCountTop10);
    }
    //查询本月总销量
    @GetMapping("/getSumSaleCount/{month}")
    public String getSumSaleCount(@PathVariable Integer month){
        int SumSaleCount = sightBasicInfoService.getSumSaleCount(month);
        return JSONUtils.toJSONString(SumSaleCount);
    }
    //查询不同等级景区数量
    @GetMapping("/getDiffStarNum")
    public String queryDiffStarNum(){
        List<HashMap<String, Integer>> DiffStarNum = sightBasicInfoService.getDiffStarNum();
        return JSONUtils.toJSONString(DiffStarNum);
    }
    //查询不同等级景区月销量
    @GetMapping("/getDiffStarSaleCount/{month}")
    public String getDiffStarSaleCount(@PathVariable Integer month){
        List<HashMap<String, Integer>> DiffStarSaleCount = sightBasicInfoService.getDiffStarSaleCount(month);
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
    //查询景区月销量前五的城市及销量
    @GetMapping("/getCitySaleCountTop5/{month}")
    public String getCitySaleCountTop5(@PathVariable Integer month){
        List<HashMap<String, String>> CitySaleCountTop5 = sightBasicInfoService.getCitySaleCountTop5(month);
        return JSONUtils.toJSONString(CitySaleCountTop5);
    }
    //查询七大地区月销量
    @GetMapping("/getZoneSaleCount/{month}")
    public String getZoneSaleCount(@PathVariable Integer month){
        List<HashMap<String, String>> ZoneSaleCount = sightBasicInfoService.getZoneSaleCount(month);
        return JSONUtils.toJSONString(ZoneSaleCount);
    }
}
