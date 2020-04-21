package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.VoteMapper;
import com.jxufe.sight.service.VoteService;
import com.jxufe.sight.vo.VoteInfoVO;
import com.jxufe.sight.vo.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteMapper voteMapper;

    @Override
    public Long saveVote(VoteInfoVO voteInfoVO) {
        return voteMapper.saveVote(voteInfoVO);
    }

    @Override
    public VoteInfoVO getVote(Long id) {
        return voteMapper.getVote(id);
    }

    @Override
    public List<VoteInfoVO> findAllVote() {
        return voteMapper.findAllVote();
    }

    @Override
    public Long findAppreciateNum(Long voteId) {
        return voteMapper.findAppreciateNum(voteId);
    }

    @Override
    public void saveAppreciateNum(Long voteId, Long appreciateNum) {
        voteMapper.saveAppreciateNum(voteId,appreciateNum);
    }
}
