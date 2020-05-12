/**
 * @Description:
 * @Package: com.jxufe.sight.service.imp
 * @ClassName: RecommendationServiceImpl
 * @Author: 徐鼎立
 * @Date: 2020/5/11 20:04
 * @version: 1.0
 * Copyright (c) 2020,All Rights Reserved.
 */
package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.RecommendationMapper;
import com.jxufe.sight.service.RecommendationService;
import com.jxufe.sight.vo.UserClick;
import com.jxufe.sight.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    private RecommendationMapper recommendationMapper;
    @Autowired
    public RecommendationServiceImpl(RecommendationMapper recommendationMapper) {
        this.recommendationMapper = recommendationMapper;
    }
    @Override
    public void saveClickNum(UserClick userClick) {
        UserClick oldUserClick = findOneByUsernameAndSightId(userClick);
//    如果之前存在记录 就点击数+1
        if (oldUserClick!=null){
            int clickNums = oldUserClick.getClickNum();
            userClick.setClickNum(clickNums+1);
            updateClickNum(userClick);
        }
        else {
            userClick.setClickNum(1);
            recommendationMapper.saveClickNum(userClick);
        }
    }

    @Override
    public UserClick findOneByUsernameAndSightId(UserClick userClick) {
        return recommendationMapper.findOneByUsernameAndSightId(userClick);
    }

    @Override
    public Long updateClickNum(UserClick userClick) {
        return recommendationMapper.updateClickNum(userClick);
    }

    @Override
    public List<HashMap<Integer, Integer>> findTwoFavouriteTypeByUsername(UserInfoVO userInfoVO) {
        return recommendationMapper.findTwoFavouriteTypeByUsername(userInfoVO);
    }
}
