package com.jxufe.sight.service;

import com.jxufe.sight.vo.TravelImgs;

import java.util.List;

public interface TravelImgService {
    Long savetravelImg(TravelImgs travelImgs);
    List<TravelImgs> findAllTravelImg(Long travelId);
}
