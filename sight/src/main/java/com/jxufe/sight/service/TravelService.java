package com.jxufe.sight.service;

import com.jxufe.sight.vo.TravelInfoVO;
import com.jxufe.sight.vo.VoteInfoVO;

import java.util.List;

public interface TravelService {

    Long saveTravel(TravelInfoVO travelInfoVO);
    TravelInfoVO getTravel(Long id);
    List<TravelInfoVO> findAllTravel();
    Long findAppreciateNum(Long travelId);
    void saveAppreciateNum(Long travelId,Long appreciateNum);
}
