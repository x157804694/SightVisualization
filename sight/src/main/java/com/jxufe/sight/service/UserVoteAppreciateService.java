package com.jxufe.sight.service;

import com.jxufe.sight.vo.UserVoteAppreciate;

import java.util.List;

public interface UserVoteAppreciateService {
    void saveUserVoteAppreciate(Long userId,Long voteId);
    void deleteUserVoteAppreciate(Long userId,Long voteId);
    List<UserVoteAppreciate> findAllUserVoteAppreciate(Long userId);
}
