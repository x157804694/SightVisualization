package com.jxufe.sight.web.client;

import com.alibaba.druid.support.json.JSONUtils;
import com.jxufe.sight.service.ProvinceVisualizationService;
import com.jxufe.sight.vo.ProvinceVisualizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ProvinceVisualization")
public class ProvinceVisualizationController {
    private String provinceValue = "北京";

    @Autowired
    ProvinceVisualizationService provinceVisualizationService;

    @GetMapping("/getProvinceSaleCountTop10/{province}")
    public List<ProvinceVisualizationVO> getProvinceSaleCountTop10(@PathVariable String province) {
        List<ProvinceVisualizationVO> provinceVisualizationVOS = provinceVisualizationService.getProvinceSaleCountTop10(province);
        return provinceVisualizationVOS;
    }

    @GetMapping("/getProvinceValue")
    public String getProvinceValue() {
        return provinceValue;
    }

    @GetMapping("/getProvinceSaleCount/{province}")
    public Integer getProvince(@PathVariable String province) {
        Integer sale = provinceVisualizationService.getSumSaleCount(province);
        return sale;
    }

    @GetMapping("/getSightPrice/{province}")
    public String getSightPrice(@PathVariable String province) {
        List<HashMap<String,Integer>> price = provinceVisualizationService.getPriceOfSight(province);
        return JSONUtils.toJSONString(price);
    }

    @GetMapping("/getCityCoordOfProvince/{province}")
    public String getCityCoordOfProvince(@PathVariable String province) {
        return JSONUtils.toJSONString(provinceVisualizationService.getCityCoord(province));
    }

    @GetMapping("/getCitySightNumOfProvince/{province}")
    public String getCitySightNumOfProvince(@PathVariable String province) {
        List<HashMap<String,Integer>> num = provinceVisualizationService.getCitySightNum(province);
        return JSONUtils.toJSONString(num);
    }

    @GetMapping("/getMonthSaleSum/{province}")
    public String getMonthSaleSum(@PathVariable String province) {
        Integer saleSum = provinceVisualizationService.getSumSaleCount(province);
        return JSONUtils.toJSONString(saleSum);
    }

    @GetMapping("/getStarOfSight/{province}")
    public String getStarOfSight(@PathVariable String province) {
        provinceValue = province;
        List<HashMap<String, String>> stars = provinceVisualizationService.getStarOfSight(province);
        return JSONUtils.toJSONString(stars);
    }

    @GetMapping("/getSaleCountSumGroupByStar/{province}")
    public String getSaleCountSumGroupByStar(@PathVariable String province) {
        List<HashMap<String, Integer>> counts = provinceVisualizationService.getSumSaleCountGroupByStar(province);
        return JSONUtils.toJSONString(counts);
    }

    @GetMapping("/getCitySightNumTop5/{province}")
    public String getCitySightNumTop5(@PathVariable String province) {
        List<HashMap<String, String>> nums = provinceVisualizationService.getCitySightNumTop5(province);
        return JSONUtils.toJSONString(nums);
    }

    @GetMapping("/getCitySaleTop5/{province}")
    public String getCitySaleTop5(@PathVariable String province) {
        List<HashMap<String, Integer>> sales = provinceVisualizationService.getCitySaleCountTop5(province);
        return JSONUtils.toJSONString(sales);
    }
}
