package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.UserTravel;
import com.jxufe.sight.vo.UserVote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserTravelMapper {

    Long findTravelNum(@Param("travelId") Long travelId);
    void saveUserTravel(@Param("userId") Long userId,@Param("travelId") Long travelId);
    List<UserTravel> findUserTravel(@Param("userId") Long userId);
    UserVote findUser(@Param("userId") Long userId,@Param("travelId") Long travelId);
}
