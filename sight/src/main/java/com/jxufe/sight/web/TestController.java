package com.jxufe.sight.web;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxufe.sight.mapper.SightBasicInfoMapper;
import com.jxufe.sight.utils.DefaultPageInfo;
import com.jxufe.sight.vo.SightBasicInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private SightBasicInfoMapper sightBasicInfoMapper;

    public TestController() {
    }

    @Autowired
    public TestController(SightBasicInfoMapper sightBasicInfoMapper) {
        this.sightBasicInfoMapper = sightBasicInfoMapper;
    }

    @RequestMapping("/t1")
    public SightBasicInfoVO getOne(long id){
        return sightBasicInfoMapper.findById(id);
    }
    @RequestMapping("/t2")
    public SightBasicInfoVO getOne(String sightId){
        return sightBasicInfoMapper.findBySightId(sightId);
    }
    @RequestMapping("/t3")
    public List<SightBasicInfoVO> getOnePage(int page,int pageSize){
        int offset=(page-1)*pageSize;
        return sightBasicInfoMapper.findOnePage(offset,pageSize);
    }
    @RequestMapping("/t4/{province}")
    public PageInfo<SightBasicInfoVO>  findPageByProvinceWithMultiCondition
            (@PathVariable("province") String province, Double start, Double end, Integer order,
               @RequestParam(required = false,defaultValue = "1")int page,
               @RequestParam(required = false , defaultValue = DefaultPageInfo.SIGHT_PAGESIZE_STR)int pageSize,
               Model model){
        PageHelper.startPage(page,pageSize);
        List<SightBasicInfoVO> sightBasicInfoVOS=sightBasicInfoMapper.findAllByProvinceWithMultiCondition(province,start,end,order);
        PageInfo<SightBasicInfoVO> pageModel = new PageInfo<>(sightBasicInfoVOS);
        return pageModel;
    }
    @RequestMapping("/t5")
    public String getCitySightNums(){
        String data = JSONUtils.toJSONString(sightBasicInfoMapper.getCitySightNum());
        return data;
    }
    @RequestMapping("/t6")
    public String getDiffStarNum(){
        String data = JSONUtils.toJSONString(sightBasicInfoMapper.getDiffStarNum());
        return data;
    }
    @RequestMapping("/t7")
    public String getDiffStarSaleCount(){
        String data = JSONUtils.toJSONString(sightBasicInfoMapper.getDiffStarSaleCount());
        return data;
    }
    @RequestMapping("/t8")
    public String getDiffPriceRangeNum(){
        String data = JSONUtils.toJSONString(sightBasicInfoMapper.getDiffPriceRangeNum(0.0,50.0));
        return data;
    }
    @RequestMapping("/t9")
    public String getCitySightNumTop5(){
        String data = JSONUtils.toJSONString(sightBasicInfoMapper.getCitySightNumTop5());
        return data;
    }
    @RequestMapping("/t10")
    public String getSightSaleCountTop10(){
        System.out.println(sightBasicInfoMapper.getSightSaleCountTop10());
        return "data";
    }
}
