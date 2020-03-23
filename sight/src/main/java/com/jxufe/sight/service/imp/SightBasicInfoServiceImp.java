package com.jxufe.sight.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxufe.sight.mapper.SightBasicInfoMapper;
import com.jxufe.sight.service.SightBasicInfoService;
import com.jxufe.sight.vo.SightBasicInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
