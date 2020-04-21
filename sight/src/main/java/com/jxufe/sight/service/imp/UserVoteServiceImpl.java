package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.UserVoteMapper;
import com.jxufe.sight.service.UserVoteService;
import com.jxufe.sight.vo.UserVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVoteServiceImpl implements UserVoteService {

    @Autowired
    private UserVoteMapper userVoteMapper;

    @Override
    public Long findVoteNum(Long voteId) {
        return userVoteMapper.findVoteNum(voteId);
    }

    @Override
    public void saveUserVote(Long userId, Long voteId) {
        userVoteMapper.saveUserVote(userId,voteId);
    }

    @Override
    public List<UserVote> findUserVote(Long userId) {
        return userVoteMapper.findUserVote(userId);
    }

    @Override
    public UserVote findUser(Long userId, Long voteId) {
        return userVoteMapper.findUser(userId,voteId);
    }
}
