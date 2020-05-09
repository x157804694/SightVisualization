package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.TravelCommentMapper;
import com.jxufe.sight.service.TravelCommentService;
import com.jxufe.sight.vo.TravelComment;
import com.jxufe.sight.vo.TravelReplyComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelCommentServiceImpl implements TravelCommentService {

    @Autowired
    private TravelCommentMapper travelCommentMapper;
    @Override
    public void saveTravelComment(TravelComment travelComment) {
        travelCommentMapper.saveTravelComment(travelComment);
    }

    @Override
    public List<TravelComment> findAllTravelComment(Long travelId) {
        return travelCommentMapper.findAllTravelComment(travelId);
    }

    @Override
    public List<TravelReplyComment> findAllTravelReplyComment(Long commentId) {
        return travelCommentMapper.findAllTravelReplyComment(commentId);
    }

    @Override
    public TravelComment findTravelCommentById(Long id) {
        return travelCommentMapper.findTravelCommentById(id);
    }

    @Override
    public void saveTravelReplyComment(TravelReplyComment travelReplyComment) {
        travelCommentMapper.saveTravelReplyComment(travelReplyComment);
    }

    @Override
    public TravelReplyComment findTravelReplyComment(Long id) {
        return travelCommentMapper.findTravelReplyComment(id);
    }
}
