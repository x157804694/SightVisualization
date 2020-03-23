package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.SightBasicInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SightBasicInfoMapper {
    SightBasicInfoVO findById(long id);
    SightBasicInfoVO findBySightId(String sightId);
    List<SightBasicInfoVO> findOnePage(@Param("offset")int offset,@Param("size")int pageSize);
    List<SightBasicInfoVO> findAllByProvinceWithMultiCondition(@Param("province")String province,@Param("start")Double start,@Param("end")Double end,@Param("order")Integer order);
    List<String> getAllProvince();
}
