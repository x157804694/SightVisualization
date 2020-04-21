package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.SightCommentsInfoMapper;
import com.jxufe.sight.service.SightCommentsService;
import com.jxufe.sight.vo.SightCommentsInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SightCommentsServiceImp implements SightCommentsService {

    private SightCommentsInfoMapper sightCommentsInfoMapper;

    public SightCommentsServiceImp() {
    }

    @Autowired
    public SightCommentsServiceImp(SightCommentsInfoMapper sightCommentsInfoMapper) {
        this.sightCommentsInfoMapper = sightCommentsInfoMapper;
    }


    @Override
    public SightCommentsInfoVO findContent(String sightId) {
        return sightCommentsInfoMapper.findContent(sightId);
    }

    @Override
    public SightCommentsInfoVO findDigitalData(String sightId) {
        return sightCommentsInfoMapper.findDigitalData(sightId);
    }
}
