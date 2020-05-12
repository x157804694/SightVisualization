package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.UserClick;
import com.jxufe.sight.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RecommendationMapper {
    Long saveClickNum(@Param("userClick") UserClick userClick);
    UserClick findOneByUsernameAndSightId(@Param("userClick") UserClick userClick);
    Long updateClickNum(@Param("userClick") UserClick userClick);
    List<HashMap<Integer,Integer>> findTwoFavouriteTypeByUsername(@Param("userInfoVO") UserInfoVO userInfoVO);
}
