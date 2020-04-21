package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.Comment;
import com.jxufe.sight.vo.ReplyComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    void saveVoteComment(@Param("comment") Comment comment);
    List<Comment> findAllComment(@Param("voteId") Long voteId);
    List<ReplyComment> findAllReplyComment(@Param("commentId") Long commentId);
    Comment findCommentById(@Param("id") Long id);
    void saveReplyComment(@Param("replyComment") ReplyComment replyComment);
    ReplyComment findReplyComment(@Param("id") Long id);
}
