package com.jxufe.sight.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxufe.sight.mapper.SightBasicInfoMapper;
import com.jxufe.sight.service.SightBasicInfoService;
import com.jxufe.sight.vo.SightBasicInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SightBasicInfoServiceImp implements SightBasicInfoService {

    private SightBasicInfoMapper sightBasicInfoMapper;

    public SightBasicInfoServiceImp() {
    }

    @Autowired
    public SightBasicInfoServiceImp(SightBasicInfoMapper sightBasicInfoMapper) {
        this.sightBasicInfoMapper = sightBasicInfoMapper;
    }

    @Override
    public PageInfo<SightBasicInfoVO> findOnePage(String province, Double start, Double end, Integer order, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<SightBasicInfoVO>(sightBasicInfoMapper.findAllByProvinceWithMultiCondition(province,start,end,order));
    }

    @Override
    public PageInfo<SightBasicInfoVO> search(String sightName, Double start, Double end, Integer order, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<SightBasicInfoVO>(sightBasicInfoMapper.search(sightName,start,end,order));
    }

    @Override
    public List<HashMap<String, Integer>> getCitySightNum(Integer month) {
        return sightBasicInfoMapper.getCitySightNum(month);
    }

    @Override
    public List<HashMap<String, Integer>> getDiffStarNum() {
        return sightBasicInfoMapper.getDiffStarNum();
    }

    @Override
    public List<HashMap<String, Integer>> getDiffStarSaleCount(Integer month) {
        return sightBasicInfoMapper.getDiffStarSaleCount(month);
    }

    @Override
    public List<HashMap<String, Integer>> getDiffPriceRangeNum() {
        List<HashMap<String, Integer>> DiffPriceRangeNum = new ArrayList<>();
        // 先算一下免费的景区
        HashMap<String, Integer> Range = new HashMap<>();
        Range.put("value",sightBasicInfoMapper.getDiffPriceRangeNum(0.0,0.0));
        DiffPriceRangeNum.add(Range);
        for (int i = 0; i <=4 ; i++) {
            Double start = i*50.0 + 1;
            Double end = (i+1)*50.0;
            if(i==4){
                end = 1000000.0;
            }
            HashMap<String, Integer> Range2 = new HashMap<>();
            Range2.put("value",sightBasicInfoMapper.getDiffPriceRangeNum(start,end));
            DiffPriceRangeNum.add(Range2);
        }
        return DiffPriceRangeNum;
    }

    @Override
    public List<HashMap<String, String>> getCitySightNumTop5() {
        return sightBasicInfoMapper.getCitySightNumTop5();
    }

    @Override
    public List<HashMap<String, String>> getCitySaleCountTop5(Integer month) {
        return  sightBasicInfoMapper.getCitySaleCountTop5(month);
    }

    @Override
    public List<HashMap<String, String>> getZoneSaleCount(Integer month) {
        return sightBasicInfoMapper.getZoneSaleCount(month);
    }

    @Override
    public List<SightBasicInfoVO> getSightSaleCountTop10(Integer month) {
        return sightBasicInfoMapper.getSightSaleCountTop10(month);
    }

    @Override
    public Integer getSumSaleCount(Integer month) {
        return sightBasicInfoMapper.getSumSaleCount(month);
    }

    @Override
    public List<SightBasicInfoVO> findBysightIds(List<String> sightIds) {
        return sightBasicInfoMapper.findBySightIds(sightIds);
    }

    @Override
    public List<String> getAllProvince() {
        return sightBasicInfoMapper.getAllProvince();
    }
}
