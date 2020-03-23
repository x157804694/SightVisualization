package com.jxufe.sight.web;

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
}
