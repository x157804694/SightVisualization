package com.jxufe.sight.web.client;

import com.jxufe.sight.service.VoteOptionService;
import com.jxufe.sight.service.VoteService;
import com.jxufe.sight.vo.UserInfoVO;
import com.jxufe.sight.vo.VoteInfoVO;
import com.jxufe.sight.vo.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LaunchVoteController {

    @Autowired
    private VoteService voteService;
    @Autowired
    private VoteOptionService voteOptionService;

    @RequestMapping("/t_votes")
    public String votes(Model model){
        return "client/t_votes";
    }

    @RequestMapping("/launchVote")
    public String launchVote(VoteInfoVO voteInfoVO, HttpSession session){
        voteInfoVO.setUserInfoVO((UserInfoVO) session.getAttribute("user"));
        Long voteId = voteService.saveVote(voteInfoVO);
        voteId = voteInfoVO.getId();
        VoteOption voteOption = new VoteOption();
        for (int i=0;i<voteInfoVO.getOptions().length;i++){
            voteOption.setVoteInfoVO(voteService.getVote(voteId));
            System.out.println("投票信息 = " + voteService.getVote(voteId));
            voteOption.setOption_name(voteInfoVO.getOptions()[i]);
            voteOptionService.saveVoteOption(voteOption);
        }
        return "redirect:/sightvote";
    }
}
