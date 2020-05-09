package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.UserTravelMapper;
import com.jxufe.sight.service.UserTravelService;
import com.jxufe.sight.vo.UserTravel;
import com.jxufe.sight.vo.UserVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTravelServiceImpl implements UserTravelService {

    @Autowired
    private UserTravelMapper userTravelMapper;
    @Override
    public Long findTravelNum(Long travelId) {
        return userTravelMapper.findTravelNum(travelId);
    }

    @Override
    public void saveUserTravel(Long userId, Long travelId) {
        userTravelMapper.saveUserTravel(userId,travelId);
    }

    @Override
    public List<UserTravel> findUserTravel(Long userId) {
        return userTravelMapper.findUserTravel(userId);
    }

    @Override
    public UserVote findUser(Long userId, Long travelId) {
        return userTravelMapper.findUser(userId,travelId);
    }
}
