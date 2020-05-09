package com.jxufe.sight.service;

import com.jxufe.sight.vo.UserTravel;
import com.jxufe.sight.vo.UserVote;

import java.util.List;

public interface UserTravelService {

    Long findTravelNum(Long travelId);
    void saveUserTravel(Long userId, Long travelId);
    List<UserTravel> findUserTravel(Long userId);
    UserVote findUser(Long userId, Long travelId);
}
