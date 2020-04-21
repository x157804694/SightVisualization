package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.UserVoteAppreciate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserVoteAppreciateMapper {
    void saveUserVoteAppreciate(@Param("userId") Long userId,@Param("voteId") Long voteId);
    void deleteUserVoteAppreciate(@Param("userId") Long userId,@Param("voteId") Long voteId);
    List<UserVoteAppreciate> findAllUserVoteAppreciate(@Param("userId") Long userId);
}
