package com.jxufe.sight.service.imp;


import com.jxufe.sight.mapper.CommentMapper;
import com.jxufe.sight.service.CommentService;
import com.jxufe.sight.vo.Comment;
import com.jxufe.sight.vo.ReplyComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Override
    public void saveVoteComment(Comment comment) {
        commentMapper.saveVoteComment(comment);
    }

    @Override
    public List<Comment> findAllComment(Long voteId) {
        return commentMapper.findAllComment(voteId);
    }

    @Override
    public List<ReplyComment> findAllReplyComment(Long commentId) {
        return commentMapper.findAllReplyComment(commentId);
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentMapper.findCommentById(id);
    }

    @Override
    public void saveReplyComment(ReplyComment replyComment) {
        commentMapper.saveReplyComment(replyComment);
    }

    @Override
    public ReplyComment findReplyComment(Long id) {
        return commentMapper.findReplyComment(id);
    }
}
