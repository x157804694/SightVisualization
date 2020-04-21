package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.VoteInfoVO;
import com.jxufe.sight.vo.VoteOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VoteMapper {
    Long saveVote(@Param("voteInfoVO") VoteInfoVO voteInfoVO);
    VoteInfoVO getVote(@Param("id") Long id);
    List<VoteInfoVO> findAllVote();
    Long findAppreciateNum(@Param("voteId") Long voteId);
    void saveAppreciateNum(@Param("voteId") Long voteId,@Param("appreciateNum") Long appreciateNum);
}
