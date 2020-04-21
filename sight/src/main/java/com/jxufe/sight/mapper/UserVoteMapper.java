package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.UserVote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserVoteMapper {
    Long findVoteNum(@Param("voteId") Long voteId);
    void saveUserVote(@Param("userId") Long userId,@Param("voteId") Long voteId);
    List<UserVote> findUserVote(@Param("userId") Long userId);
    UserVote findUser(@Param("userId") Long userId,@Param("voteId") Long voteId);
}
