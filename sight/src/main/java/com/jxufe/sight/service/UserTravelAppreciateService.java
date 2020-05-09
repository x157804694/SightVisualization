package com.jxufe.sight.service;

import com.jxufe.sight.vo.UserTravelAppreciate;
import com.jxufe.sight.vo.UserVoteAppreciate;

import java.util.List;

public interface UserTravelAppreciateService {
    void saveUserTravelAppreciate(Long userId, Long travelId);
    void deleteUserTravelAppreciate(Long userId, Long travelId);
    List<UserTravelAppreciate> findAllUserTravelAppreciate(Long userId);
}
