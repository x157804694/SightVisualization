package com.jxufe.sight.service;

import com.github.pagehelper.PageInfo;
import com.jxufe.sight.vo.SightBasicInfoVO;

public interface SightBasicInfoService {
    PageInfo<SightBasicInfoVO> findOnePage(String province, Double start, Double end, Integer order, int page, int pageSize);
}
