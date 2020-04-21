package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.VoteOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface VoteOptionMapper {

    Long saveVoteOption(@Param("voteOption") VoteOption voteOption);
    VoteOption getVoteOption(@Param("id") Long id);
    Page<VoteOption> listVoteOption(@Param("vote_id") Long vote_id,Pageable pageable);
    List<VoteOption> listVoteOption(@Param("vote_id") Long vote_id);
    void deleteVoteOption(@Param("id") Long id);
    void updateVoteOption(@Param("voteOption") VoteOption voteOption);
    Long findVoteOptionNum(@Param("id") Long id);
}
