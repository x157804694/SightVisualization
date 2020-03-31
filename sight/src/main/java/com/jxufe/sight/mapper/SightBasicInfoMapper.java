package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.SightBasicInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SightBasicInfoMapper {
    SightBasicInfoVO findById(long id);
    SightBasicInfoVO findBySightId(String sightId);
    List<SightBasicInfoVO> findOnePage(@Param("offset")int offset,@Param("size")int pageSize);
    List<SightBasicInfoVO> findAllByProvinceWithMultiCondition(@Param("province")String province,@Param("start")Double start,@Param("end")Double end,@Param("order")Integer order);
    List<String> getAllProvince();
    // 查询月销量前10的景区
    List<SightBasicInfoVO> getSightSaleCountTop10();
    // 查询本月总销量
    Integer getSumSaleCount();
    // 查询每个城市有多少个景区，key城市 value景区数量
    List<HashMap<String, Integer>> getCitySightNum();
    // 查询不同等级景区数量
    List<HashMap<String, Integer>> getDiffStarNum();
    // 查询不同等级景区月销量
    List<HashMap<String, Integer>> getDiffStarSaleCount();
    // 查询不同价格区间景区数量
    Integer getDiffPriceRangeNum(@Param("start") Double start,@Param("end") Double end);
    // 查询景区数量前五的城市中各等级景区数量及总数
    List<HashMap<String, String>> getCitySightNumTop5();
    // 查询月销量前五的城市及销量
    List<HashMap<String, String>> getCitySaleCountTop5();
}
