package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.TravelMapper;
import com.jxufe.sight.service.TravelService;
import com.jxufe.sight.vo.TravelInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelMapper travelMapper;

    @Override
    public Long saveTravel(TravelInfoVO travelInfoVO) {
        return travelMapper.saveTravel(travelInfoVO);
    }

    @Override
    public TravelInfoVO getTravel(Long id) {
        return travelMapper.getTravel(id);
    }

    @Override
    public List<TravelInfoVO> findAllTravel() {
        return travelMapper.findAllTravel();
    }

    @Override
    public Long findAppreciateNum(Long travelId) {
        return travelMapper.findAppreciateNum(travelId);
    }

    @Override
    public void saveAppreciateNum(Long travelId, Long appreciateNum) {
        travelMapper.saveAppreciateNum(travelId,appreciateNum);
    }
}
