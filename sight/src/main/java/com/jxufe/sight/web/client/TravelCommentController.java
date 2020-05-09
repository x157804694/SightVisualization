package com.jxufe.sight.web.client;

import com.jxufe.sight.service.TravelCommentService;
import com.jxufe.sight.service.UserService;
import com.jxufe.sight.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class TravelCommentController {

    @Autowired
    private TravelCommentService travelCommentService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/addTravelComment")
    public TravelComment addTravelComment(TravelComment travelComment, HttpSession session){
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        System.out.println(user);
        System.out.println("yonghu: " + user.getId());
        travelComment.setUser(user);
        travelComment.setFrom_uid(user.getId());
        travelCommentService.saveTravelComment(travelComment);
        travelComment.setId(travelComment.getId());
        return travelComment;
    }

    @ResponseBody
    @PostMapping("/addTravelReplyComment")
    public TravelReplyComment addTravelReplyComment(TravelReplyComment travelReplyComment, HttpSession session){
        System.out.println("评论ID = " + travelReplyComment.getComment_id());
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        System.out.println("用户 = " + user);
        travelReplyComment.setFrom_user_avatar(user.getAvatar());
        travelReplyComment.setFrom_user_nickname(user.getNickname());
        TravelComment travelComment = travelCommentService.findTravelCommentById(travelReplyComment.getComment_id());
        if (travelComment != null){ //判断是否是根与回复
            travelReplyComment.setTo_user_nickname(userService.findUserById(travelComment.getFrom_uid()).getNickname());
        } else {
            travelReplyComment.setTo_user_nickname(travelCommentService.findTravelReplyComment(travelReplyComment.getComment_id()).getFrom_user_nickname());
            travelReplyComment.setComment_id(travelCommentService.findTravelReplyComment(travelReplyComment.getComment_id()).getComment_id());
        }
        travelCommentService.saveTravelReplyComment(travelReplyComment);
        travelReplyComment.setId(travelReplyComment.getId());
        return travelReplyComment;
    }
}
