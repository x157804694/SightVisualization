package com.jxufe.sight.service;

import com.jxufe.sight.vo.VoteInfoVO;
import com.jxufe.sight.vo.VoteOption;

import java.util.List;

public interface VoteService {

    Long saveVote(VoteInfoVO voteInfoVO);
    VoteInfoVO getVote(Long id);
    List<VoteInfoVO> findAllVote();
    Long findAppreciateNum(Long voteId);
    void saveAppreciateNum(Long voteId,Long appreciateNum);
}
