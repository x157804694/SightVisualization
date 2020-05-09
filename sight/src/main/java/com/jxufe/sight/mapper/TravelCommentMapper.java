package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.TravelComment;
import com.jxufe.sight.vo.TravelReplyComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelCommentMapper {

    void saveTravelComment(@Param("travelComment") TravelComment travelComment);
    List<TravelComment> findAllTravelComment(@Param("travelId") Long travelId);
    List<TravelReplyComment> findAllTravelReplyComment(@Param("commentId") Long commentId);
    TravelComment findTravelCommentById(@Param("id") Long id);
    void saveTravelReplyComment(@Param("travelReplyComment") TravelReplyComment travelReplyComment);
    TravelReplyComment findTravelReplyComment(@Param("id") Long id);
}
