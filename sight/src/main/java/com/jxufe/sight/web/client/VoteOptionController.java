package com.jxufe.sight.web.client;

import com.jxufe.sight.service.UserVoteAppreciateService;
import com.jxufe.sight.service.UserVoteService;
import com.jxufe.sight.service.VoteOptionService;
import com.jxufe.sight.service.VoteService;
import com.jxufe.sight.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class VoteOptionController {

    @Autowired
    private VoteOptionService voteOptionService;
    @Autowired
    private VoteService voteService;
    @Autowired
    private UserVoteService userVoteService;
    @Autowired
    private UserVoteAppreciateService userVoteAppreciateService;

    //投票Ajax请求
    @ResponseBody
    @PostMapping("/addVoteOptionNum")
    public List<VoteOption> addVoteNum(VoteQuery voteQuery, HttpSession session){
        System.out.println("skdlfhuivboibediorbvoisdnogvieroivnpeior");
        Long Id = voteQuery.getId();
        Long voteId = voteQuery.getVoteId();
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        Long userid = user.getId();
        VoteOption voteOption = voteOptionService.getVoteOption(Id);
        voteOption.setVote_num(voteOption.getVote_num()+1);
        voteOption.setVoteInfoVO(voteService.getVote(voteId));
        voteOptionService.updateVoteOption(voteOption);
        userVoteService.saveUserVote(userid,voteId);
        //找出voteId这个模块下的投票总数
        Long voteNum = userVoteService.findVoteNum(voteId);
        //找出voteId这个模块下的所有voteOptions
        List<VoteOption> voteOptions = voteOptionService.listVoteOption(voteId);
        for (int i=0;i<voteOptions.size();i++){
            voteOptions.get(i).setVoteNum(voteNum);
            voteOptions.get(i).setRatio((double) 100*((double)voteOptions.get(i).getVote_num()/voteNum));
        }
        System.out.println(voteOptions);
        return voteOptions;
    }

    @ResponseBody
    @PostMapping("/addVoteAppreciateNum")
    public VoteInfoVO addVoteAppreciateNum(@RequestParam Long voteId,HttpSession session){
        System.out.println("投票ID = " + voteId);
        Long appreciateNum = voteService.findAppreciateNum(voteId) + 1;
        voteService.saveAppreciateNum(voteId,appreciateNum);
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        userVoteAppreciateService.saveUserVoteAppreciate(user.getId(),voteId);
        VoteInfoVO voteInfoVO = voteService.getVote(voteId);
        return voteInfoVO;
    }

    @ResponseBody
    @PostMapping("/subVoteAppreciateNum")
    public VoteInfoVO subVoteAppreciateNum(@RequestParam Long voteId,HttpSession session){
        System.out.println("投票ID = " + voteId);
        Long appreciateNum = voteService.findAppreciateNum(voteId) - 1;
        voteService.saveAppreciateNum(voteId,appreciateNum);
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        userVoteAppreciateService.deleteUserVoteAppreciate(user.getId(),voteId);
        VoteInfoVO voteInfoVO = voteService.getVote(voteId);
        return voteInfoVO;
    }
}
