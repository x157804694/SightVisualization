package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.VoteOptionMapper;
import com.jxufe.sight.service.VoteOptionService;
import com.jxufe.sight.vo.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteOptionServiceImpl implements VoteOptionService {

    private VoteOptionMapper voteOptionMapper;

    public VoteOptionServiceImpl() {
    }

    @Autowired
    public VoteOptionServiceImpl(VoteOptionMapper voteOptionMapper) {
        this.voteOptionMapper = voteOptionMapper;
    }

    @Override
    public Long saveVoteOption(VoteOption voteOption) {
        return voteOptionMapper.saveVoteOption(voteOption);
    }

    @Override
    public VoteOption getVoteOption(Long id) {
        return voteOptionMapper.getVoteOption(id);
    }


    @Override
    public List<VoteOption> listVoteOption(Long vote_id) {
        return voteOptionMapper.listVoteOption(vote_id);
    }

    @Override
    public void deleteVoteOption(Long id) {
        voteOptionMapper.deleteVoteOption(id);
    }

    @Override
    public void updateVoteOption(VoteOption voteOption) {
        voteOptionMapper.updateVoteOption(voteOption);
    }

    @Override
    public Long findVoteOptionNum(Long id) {
        return voteOptionMapper.findVoteOptionNum(id);
    }

}
