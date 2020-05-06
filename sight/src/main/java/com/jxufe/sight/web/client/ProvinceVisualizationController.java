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

    @GetMapping("/getProvinceSaleCountTop10/{province}/{month}")
    public List<ProvinceVisualizationVO> getProvinceSaleCountTop10(@PathVariable String province,@PathVariable Integer month) {
        List<ProvinceVisualizationVO> provinceVisualizationVOS = provinceVisualizationService.getProvinceSaleCountTop10(province,month);
        return provinceVisualizationVOS;
    }

    @GetMapping("/getProvinceValue")
    public String getProvinceValue() {
        return provinceValue;
    }

    @GetMapping("/getProvinceSaleCount/{province}/{month}")
    public Integer getProvinceSaleCount(@PathVariable String province,@PathVariable Integer month) {
        Integer sale = provinceVisualizationService.getSumSaleCount(province,month);
        return sale;
    }

    @GetMapping("/getSightPrice/{province}")
    public String getSightPrice(@PathVariable String province){
        List<HashMap<String,Integer>> price = provinceVisualizationService.getPriceOfSight(province);
        return JSONUtils.toJSONString(price);
    }

    @GetMapping("/getCityCoordOfProvince/{province}")
    public String getCityCoordOfProvince(@PathVariable String province) {
        return JSONUtils.toJSONString(provinceVisualizationService.getCityCoord(province));
    }

    @GetMapping("/getCitySightSaleCountOfProvince/{province}/{month}")
    public String getCitySightSaleCountOfProvince(@PathVariable String province,@PathVariable Integer month) {
        List<HashMap<String,Integer>> num = provinceVisualizationService.getCitySightSaleCount(province,month);
        return JSONUtils.toJSONString(num);
    }

    @GetMapping("/getStarOfSight/{province}")
    public String getStarOfSight(@PathVariable String province) {
        provinceValue = province;
        List<HashMap<String, String>> stars = provinceVisualizationService.getStarOfSight(province);
        return JSONUtils.toJSONString(stars);
    }

    @GetMapping("/getSaleCountSumGroupByStar/{province}/{month}")
    public String getSaleCountSumGroupByStar(@PathVariable String province,@PathVariable Integer month) {
        List<HashMap<String, Integer>> counts = provinceVisualizationService.getSumSaleCountGroupByStar(province,month);
        return JSONUtils.toJSONString(counts);
    }

    @GetMapping("/getCitySightNumTop5/{province}")
    public String getCitySightNumTop5(@PathVariable String province) {
        List<HashMap<String, String>> nums = provinceVisualizationService.getCitySightNumTop5(province);
        return JSONUtils.toJSONString(nums);
    }

    @GetMapping("/getCitySaleTop5/{province}/{month}")
    public String getCitySaleTop5(@PathVariable String province,@PathVariable Integer month) {
        List<HashMap<String, Integer>> sales = provinceVisualizationService.getCitySaleCountTop5(province,month);
        return JSONUtils.toJSONString(sales);
    }

    //直辖市，经济特区评论总数Top5
    @GetMapping("/getSightCommentNumTop5/{province}")
    public String getSightCommentNumTop5(@PathVariable String province) {
        List<HashMap<String, String>> comNum = provinceVisualizationService.getSightCommentNumTop5(province);
        return JSONUtils.toJSONString(comNum);
    }
    //直辖市，经济特区好评数Top5
    @GetMapping("/getSightSaleOfMonth/{province}")
    public String getSightSaleOfMonth(@PathVariable String province) {
        List<HashMap<String, Integer>> goodComNum = provinceVisualizationService.getSightSaleOfMonth(province);
        return JSONUtils.toJSONString(goodComNum);
    }
}
