package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.UserTravelAppreciate;
import com.jxufe.sight.vo.UserVoteAppreciate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserTravelAppreciateMapper {
    void saveUserTravelAppreciate(@Param("userId") Long userId,@Param("travelId") Long travelId);
    void deleteUserTravelAppreciate(@Param("userId") Long userId,@Param("travelId") Long travelId);
    List<UserTravelAppreciate> findAllUserTravelAppreciate(@Param("userId") Long userId);
}
