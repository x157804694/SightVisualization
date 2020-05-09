package com.jxufe.sight.service;

import com.jxufe.sight.vo.Comment;
import com.jxufe.sight.vo.ReplyComment;
import com.jxufe.sight.vo.TravelComment;
import com.jxufe.sight.vo.TravelReplyComment;

import java.util.List;

public interface TravelCommentService {

    void saveTravelComment(TravelComment travelComment);
    List<TravelComment> findAllTravelComment(Long travelId);
    List<TravelReplyComment> findAllTravelReplyComment(Long commentId);
    TravelComment findTravelCommentById(Long id);
    void saveTravelReplyComment(TravelReplyComment travelReplyComment);
    TravelReplyComment findTravelReplyComment(Long id);
}
