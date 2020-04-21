package com.jxufe.sight.service;

import com.jxufe.sight.vo.UserVote;

import java.util.List;

public interface UserVoteService {

    Long findVoteNum(Long voteId);
    void saveUserVote(Long userId,Long voteId);
    List<UserVote> findUserVote(Long userId);
    UserVote findUser(Long userId,Long voteId);
}
