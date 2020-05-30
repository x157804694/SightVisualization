/**
 * @Description:
 * @Package: com.jxufe.sight.web.client
 * @ClassName: VisualizationController
 * @Author: 徐鼎立
 * @Date: 2020/3/31 20:05
 * @version: 1.0
 * Copyright (c) 2020,All Rights Reserved.
 */
package com.jxufe.sight.web.client;

import com.jxufe.sight.service.ProvinceVisualizationService;
import com.jxufe.sight.service.SightBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SightVisualization")
//此控制器用来控制菜单栏点击后跳转到相应页面
public class VisualizationController {

    @Autowired
    private SightBasicInfoService sightBasicInfoService;
    @Autowired
    private ProvinceVisualizationService provinceVisualizationService;

    @RequestMapping("/{province}")
    public String SightVisualization(@PathVariable String province, Model model) {
        if (province.equals("全国")) {
            //把月销量前10的景区信息和本月总销量添加到Model 用thymeleaf表达式填充表格
            model.addAttribute("SightSaleCountTop10", sightBasicInfoService.getSightSaleCountTop10(5));
            model.addAttribute("SumSaleCount", sightBasicInfoService.getSumSaleCount(5));
            return "client/CNSightVisualization";
        }
        //把省份信息传到前端，前端再用ajax读取
        else {
            model.addAttribute("SightOfProvinceSaleCountTop10", provinceVisualizationService.getProvinceSaleCountTop10("北京",5));
            model.addAttribute("AllProvince", sightBasicInfoService.getAllProvince());
            model.addAttribute("Month", "五月");
            return "client/ProvinceSightVisualization";
        }
    }

    @RequestMapping("/updateSightSaleCountTop10/{month}")
    public String updateSightSaleCountTop10(@PathVariable int month, Model model) {
        model.addAttribute("SightSaleCountTop10", sightBasicInfoService.getSightSaleCountTop10(month));
        model.addAttribute("SumSaleCount", sightBasicInfoService.getSumSaleCount(month));
        return "client/CNSightVisualization::table";
    }
    @RequestMapping("/updateSumSaleCount/{month}")
    public String updateSumSaleCount(@PathVariable int month, Model model) {
        model.addAttribute("SumSaleCount", sightBasicInfoService.getSumSaleCount(month));
        return "client/CNSightVisualization::sumOfSaleCount";
    }
}
