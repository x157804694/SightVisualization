package com.jxufe.sight.service.imp;


import com.jxufe.sight.mapper.UserTravelAppreciateMapper;
import com.jxufe.sight.mapper.UserTravelMapper;
import com.jxufe.sight.service.UserTravelAppreciateService;
import com.jxufe.sight.vo.UserTravelAppreciate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTravelAppreciateServiceImpl implements UserTravelAppreciateService {

    @Autowired
    private UserTravelAppreciateMapper userTravelAppreciateMapper;

    @Override
    public void saveUserTravelAppreciate(Long userId, Long travelId) {
        userTravelAppreciateMapper.saveUserTravelAppreciate(userId,travelId);
    }

    @Override
    public void deleteUserTravelAppreciate(Long userId, Long travelId) {
        userTravelAppreciateMapper.deleteUserTravelAppreciate(userId,travelId);
    }

    @Override
    public List<UserTravelAppreciate> findAllUserTravelAppreciate(Long userId) {
        return userTravelAppreciateMapper.findAllUserTravelAppreciate(userId);
    }
}
