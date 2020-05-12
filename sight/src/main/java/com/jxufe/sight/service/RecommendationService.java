package com.jxufe.sight.service;

import com.jxufe.sight.vo.UserClick;
import com.jxufe.sight.vo.UserInfoVO;

import java.util.HashMap;
import java.util.List;

public interface RecommendationService {
    void saveClickNum(UserClick userClick);
    UserClick findOneByUsernameAndSightId(UserClick userClick);
    Long updateClickNum(UserClick userClick);
    List<HashMap<Integer,Integer>> findTwoFavouriteTypeByUsername(UserInfoVO userInfoVO);
}
