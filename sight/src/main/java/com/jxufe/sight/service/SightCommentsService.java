package com.jxufe.sight.service;

import com.jxufe.sight.vo.SightCommentsInfoVO;

public interface SightCommentsService {
    SightCommentsInfoVO findContent(String sightId);
    SightCommentsInfoVO findDigitalData(String sightId);
}
