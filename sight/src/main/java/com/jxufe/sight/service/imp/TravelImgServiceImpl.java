package com.jxufe.sight.service.imp;

import com.jxufe.sight.bean.UploadPathManagement;
import com.jxufe.sight.mapper.TravelImgMapper;
import com.jxufe.sight.service.TravelImgService;
import com.jxufe.sight.vo.TravelImgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelImgServiceImpl implements TravelImgService {

    @Autowired
    private TravelImgMapper travelImgMapper;
    @Autowired
    private UploadPathManagement uploadPathManagement;
    @Override
    public Long savetravelImg(TravelImgs travelImgs) {
        travelImgs.setImg_url(uploadPathManagement.getTravelImgsAccessPath().substring(0,uploadPathManagement.getTravelImgsAccessPath().indexOf("**"))+travelImgs.getImg_url());
        return travelImgMapper.savetravelImg(travelImgs);
    }

    @Override
    public List<TravelImgs> findAllTravelImg(Long travelId) {
        return travelImgMapper.findAllTravelImg(travelId);
    }
}
