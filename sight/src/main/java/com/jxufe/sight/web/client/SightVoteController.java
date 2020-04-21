package com.jxufe.sight.web.client;

import com.jxufe.sight.service.*;
import com.jxufe.sight.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sightvote")
public class SightVoteController {

    @Autowired
    private VoteService voteService;
    @Autowired
    private UserService userService;
    @Autowired
    private VoteOptionService voteOptionService;
    @Autowired
    private UserVoteService userVoteService;
    @Autowired
    private UserVoteAppreciateService userVoteAppreciateService;
    @Autowired
    private CommentService commentService;

    @GetMapping
    public String sightvote(Model model, HttpSession session){
        List<VoteInfoVO> voteInfoVOList = voteService.findAllVote();
        for (int i=0;i<voteInfoVOList.size();i++){
            //voteInfoVOList.get(i).setVoteOptions(voteOptionService.listVoteOption(voteInfoVOList.get(i).getId()));
            voteInfoVOList.get(i).setUserInfoVO(userService.findUserById(voteInfoVOList.get(i).getUser_id()));
            //找出voteId这个模块下的投票总数
            Long voteNum = userVoteService.findVoteNum(voteInfoVOList.get(i).getId());
            System.out.println("投票Id = " + voteInfoVOList.get(i).getId() + "投票总数 = " + voteNum);
            //找出voteId这个模块下的所有voteOptions
            List<VoteOption> voteOptions = voteOptionService.listVoteOption(voteInfoVOList.get(i).getId());
            for (int j=0;j<voteOptions.size();j++){
                voteOptions.get(j).setVoteNum(voteNum);
                if(voteNum!=0){
                    voteOptions.get(j).setRatio((double) 100*((double)voteOptions.get(j).getVote_num()/voteNum));
                } else {
                    voteOptions.get(j).setRatio(0.00);
                }
                //System.out.println("投票选项 = " + voteOptions.get());
            }
            voteInfoVOList.get(i).setVoteOptions(voteOptions);
            System.out.println("voteOptions = " + voteInfoVOList.get(i).getVoteOptions());
            //找出voteId这个模块下的所有comments
            List<Comment> comments = commentService.findAllComment(voteInfoVOList.get(i).getId());
            for (int j=0;j<comments.size();j++){
                comments.get(j).setReplyComments(commentService.findAllReplyComment(comments.get(j).getId()));
                comments.get(j).setUser(userService.findUserById(comments.get(j).getFrom_uid()));
            }
            voteInfoVOList.get(i).setComments(comments);
            System.out.println("评论信息:" + comments);
        }
        if (session.getAttribute("user") != null){
            //找出当前用户所投过票的所有模块
            List<Long> userVoteList = new ArrayList<>();
            UserInfoVO user = (UserInfoVO) session.getAttribute("user");
            List<UserVote> userVotes = userVoteService.findUserVote(user.getId());
            for (int i=0;i<userVotes.size();i++){
                userVoteList.add(userVotes.get(i).getVote_id());
            }
            System.out.println("集合: " + userVoteList);
            model.addAttribute("userVoteList",userVoteList);
            //找出当前用户所点过赞的所有模块
            List<Long> userAppreciateVoteList = new ArrayList<>();
            List<UserVoteAppreciate> userVoteAppreciates = userVoteAppreciateService.findAllUserVoteAppreciate(user.getId());
            for (int i=0;i<userVoteAppreciates.size();i++){
                userAppreciateVoteList.add(userVoteAppreciates.get(i).getAppreciatevote_id());
            }
            System.out.println("集合: " + userAppreciateVoteList);
            model.addAttribute("userAppreciateVoteList",userAppreciateVoteList);
        }
        model.addAttribute("Vote",voteInfoVOList);
        return "client/sightVote";
    }

}
