package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.UserVoteAppreciateMapper;
import com.jxufe.sight.service.UserVoteAppreciateService;
import com.jxufe.sight.vo.UserVoteAppreciate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVoteAppreciateServiceImpl implements UserVoteAppreciateService {

    @Autowired
    private UserVoteAppreciateMapper userVoteAppreciateMapper;
    @Override
    public void saveUserVoteAppreciate(Long userId, Long voteId) {
        userVoteAppreciateMapper.saveUserVoteAppreciate(userId,voteId);
    }

    @Override
    public void deleteUserVoteAppreciate(Long userId, Long voteId) {
        userVoteAppreciateMapper.deleteUserVoteAppreciate(userId,voteId);
    }

    @Override
    public List<UserVoteAppreciate> findAllUserVoteAppreciate(Long userId) {
        return userVoteAppreciateMapper.findAllUserVoteAppreciate(userId);
    }
}
