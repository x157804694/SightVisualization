package com.jxufe.sight.service;

import com.jxufe.sight.vo.Comment;
import com.jxufe.sight.vo.ReplyComment;
import com.jxufe.sight.vo.UserInfoVO;

import java.util.List;

public interface CommentService {

    void saveVoteComment(Comment comment);
    List<Comment> findAllComment(Long voteId);
    List<ReplyComment> findAllReplyComment(Long commentId);
    Comment findCommentById(Long id);
    void saveReplyComment(ReplyComment replyComment);
    ReplyComment findReplyComment(Long id);
}
