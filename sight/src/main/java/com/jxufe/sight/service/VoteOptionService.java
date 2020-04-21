package com.jxufe.sight.service;

import com.jxufe.sight.vo.VoteOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VoteOptionService {

    Long saveVoteOption(VoteOption voteOption);
    VoteOption getVoteOption(Long id);
    List<VoteOption> listVoteOption(Long vote_id);
    void deleteVoteOption(Long id);
    void updateVoteOption(VoteOption voteOption);
    Long findVoteOptionNum(Long id);

}
