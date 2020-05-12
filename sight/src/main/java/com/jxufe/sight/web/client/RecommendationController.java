/**
 * @Description:
 * @Package: com.jxufe.sight.web.client
 * @ClassName: RecommendationController
 * @Author: 徐鼎立
 * @Date: 2020/5/11 19:19
 * @version: 1.0
 * Copyright (c) 2020,All Rights Reserved.
 */
package com.jxufe.sight.web.client;

import com.jxufe.sight.service.RecommendationService;
import com.jxufe.sight.service.SightBasicInfoService;
import com.jxufe.sight.service.SightCategoryService;
import com.jxufe.sight.vo.SightBasicInfoVO;
import com.jxufe.sight.vo.SightCategory;
import com.jxufe.sight.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class RecommendationController {
    @Autowired
    private SightBasicInfoService sightBasicInfoService;
    @Autowired
    private SightCategoryService sightCategoryService;
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public String recommendation(Model model,HttpSession session){
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
//        用户必须登陆
        if(user!=null){
            List<HashMap<Integer,Integer>> TwoFavouriteType = recommendationService.findTwoFavouriteTypeByUsername(user);
//            用户必须点击过两个类型的景区，否则就随机选10个景区
            if (!TwoFavouriteType.isEmpty()){
                List<Integer> typeList = new ArrayList<>();
                for (HashMap<Integer,Integer> type:TwoFavouriteType){
                    typeList.add(type.get("type"));
                }
                System.out.println("-----typelist-----:"+typeList);
                List<SightCategory> sightCategories = new ArrayList<>();
                for(Integer type:typeList){
                    sightCategories.addAll(sightCategoryService.findSightRandomlyByType(type));
                }
                //把景区信息添加到Model 用thymeleaf表达式填充表格
                List<String> sightIds = new ArrayList<String>();
                for (SightCategory sightCategory:sightCategories){
                    sightIds.add(sightCategory.getSightId());
                }
                List<SightBasicInfoVO> sightBasicInfoVOS = sightBasicInfoService.findBysightIds(sightIds);
                model.addAttribute("sights", sightBasicInfoVOS);
            }
            else{
                List<SightCategory> sightCategories = sightCategoryService.findSightRandomly();
                List<String> sightIds = new ArrayList<String>();
                for (SightCategory sightCategory:sightCategories){
                    sightIds.add(sightCategory.getSightId());
                }
                List<SightBasicInfoVO> sightBasicInfoVOS = sightBasicInfoService.findBysightIds(sightIds);
                model.addAttribute("sights", sightBasicInfoVOS);
            }
        }
        return "client/recommendation";
    }
}
