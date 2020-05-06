package com.jxufe.sight.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.jxufe.sight.mapper.ProvinceVisualizationMapper;
import com.jxufe.sight.service.ProvinceVisualizationService;
import com.jxufe.sight.vo.ProvinceVisualizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class ProvinceVisualizationServiceImp implements ProvinceVisualizationService{
    private ProvinceVisualizationMapper provinceVisualizationMapper;

    public ProvinceVisualizationServiceImp() {
    }

    @Autowired
    public ProvinceVisualizationServiceImp(ProvinceVisualizationMapper provinceVisualizationMapper) {
        this.provinceVisualizationMapper = provinceVisualizationMapper;
    }

    @Override
    public List<ProvinceVisualizationVO> getProvinceSaleCountTop10(String province,Integer month) {
        return provinceVisualizationMapper.getProvinceSaleCountTop10(province,month);
    }

    @Override
    public List<HashMap<String,Integer>> getPriceOfSight(String province) {
        List<HashMap<String, Integer>> DiffPriceRangeNum = new ArrayList<>();
        // 先算一下免费的景区
        HashMap<String, Integer> Range = new HashMap<>();
        Range.put("value",provinceVisualizationMapper.getPriceOfSight(0.0,50.0,province));
        DiffPriceRangeNum.add(Range);
        for (int i = 0; i <=4 ; i++) {
            Double start = i*50.0 + 1;
            Double end = (i+1)*50.0;
            if(i==4){
                end = 1000000.0;
            }
            HashMap<String, Integer> Range2 = new HashMap<>();
            Range2.put("value",provinceVisualizationMapper.getPriceOfSight(start,end,province));
            DiffPriceRangeNum.add(Range2);
        }
        return DiffPriceRangeNum;
    }

    @Override
    public List<HashMap<String, Integer>> getCitySightSaleCount(String province,Integer month) {
        return provinceVisualizationMapper.getCitySightSaleCount(province,month);
    }

    @Override
    public List<HashMap<String, String>> getStarOfSight(String province) {
        return provinceVisualizationMapper.getStarOfSight(province);
    }

    @Override
    public List<HashMap<String, ArrayList>> getCityCoord(String province) {
        List<HashMap<String, ArrayList>> geocoord = provinceVisualizationMapper.getCityCoord(province);
//        JSONObject json = new JSONObject();
//        for(int i=0;i<geocoord.size();i++){
//            HashMap<String,ArrayList> hashMap = geocoord.get(i);
//            String[] values = (hashMap.get("value")).split("，");
//            String value = values[0]+", "+values[1];
//            json.put(hashMap.get("sightName"),value);
//        }
        return geocoord;
    }

    @Override
    public List<HashMap<String, String>> getCitySightNumTop5(String province) {
        return provinceVisualizationMapper.getCitySightNumTop5(province);
    }

    @Override
    public Integer getSumSaleCount(String province,Integer month) {
        return provinceVisualizationMapper.getSumSaleCount(province,month);
    }

    @Override
    public List<HashMap<String, Integer>> getSumSaleCountGroupByStar(String province,Integer month) {
        return provinceVisualizationMapper.getSumSaleCountGroupByStar(province,month);
    }

    @Override
    public List<HashMap<String, Integer>> getCitySaleCountTop5(String province,Integer month) {
        return provinceVisualizationMapper.getCitySaleCountTop5(province,month);
    }

    @Override
    public List<HashMap<String, Integer>> getSightSaleOfMonth(String province) {
        return provinceVisualizationMapper.getSightSaleOfMonth(province);
    }

    @Override
    public List<HashMap<String, String>> getSightCommentNumTop5(String province) {
        return provinceVisualizationMapper.getSightCommentNumTop5(province);
    }
}
