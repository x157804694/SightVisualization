package com.jxufe.sight.web.client;

import com.jxufe.sight.service.CommentService;
import com.jxufe.sight.service.UserService;
import com.jxufe.sight.vo.Comment;
import com.jxufe.sight.vo.ReplyComment;
import com.jxufe.sight.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/addVoteComment")
    public Comment addVoteComment(Comment comment, HttpSession session){
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        comment.setUser(user);
        comment.setFrom_uid(user.getId());
        commentService.saveVoteComment(comment);
        comment.setId(comment.getId());
        return comment;
    }

    @ResponseBody
    @PostMapping("/addVoteReplyComment")
    public ReplyComment addVoteReplyComment(ReplyComment replyComment,HttpSession session){
        System.out.println("评论ID = " + replyComment.getComment_id());
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        System.out.println("用户 = " + user);
        replyComment.setFrom_user_avatar(user.getAvatar());
        replyComment.setFrom_user_nickname(user.getNickname());
        Comment comment = commentService.findCommentById(replyComment.getComment_id());
        if (comment != null){ //判断是否是根与回复
            replyComment.setTo_user_nickname(userService.findUserById(comment.getFrom_uid()).getNickname());
        } else {
            replyComment.setTo_user_nickname(commentService.findReplyComment(replyComment.getComment_id()).getFrom_user_nickname());
            replyComment.setComment_id(commentService.findReplyComment(replyComment.getComment_id()).getComment_id());
        }
        commentService.saveReplyComment(replyComment);
        replyComment.setId(replyComment.getId());
        return replyComment;
    }
}
