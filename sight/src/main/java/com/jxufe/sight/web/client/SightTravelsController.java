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
@RequestMapping("/sighttravels")
public class SightTravelsController {

    @Autowired
    private TravelService travelService;
    @Autowired
    private UserService userService;
    @Autowired
    private TravelImgService travelImgService;
    @Autowired
    private UserTravelAppreciateService userTravelAppreciateService;
    @Autowired
    private TravelCommentService travelCommentService;

    @GetMapping
    public String sighttravels(Model model,HttpSession session){

        List<TravelInfoVO> travelInfoVOList = travelService.findAllTravel();
        for (int i=0;i<travelInfoVOList.size();i++){
            travelInfoVOList.get(i).setUserInfoVO(userService.findUserById(travelInfoVOList.get(i).getUser_id()));
            List<TravelImgs> travelImgsList = travelImgService.findAllTravelImg(travelInfoVOList.get(i).getId());
            travelInfoVOList.get(i).setTravelImgs(travelImgsList);
            System.out.println(travelImgsList);
            //找出voteId这个模块下的所有comments
            List<TravelComment> travelComments = travelCommentService.findAllTravelComment(travelInfoVOList.get(i).getId());
            for (int j=0;j<travelComments.size();j++){
                travelComments.get(j).setTravelReplyComments(travelCommentService.findAllTravelReplyComment(travelComments.get(j).getId()));
                travelComments.get(j).setUser(userService.findUserById(travelComments.get(j).getFrom_uid()));
            }
            travelInfoVOList.get(i).setTravelComments(travelComments);
            System.out.println("评论信息:" + travelComments);
        }
        if (session.getAttribute("user") != null){
            //找出当前用户所点过赞的所有模块
            UserInfoVO user = (UserInfoVO) session.getAttribute("user");
            System.out.println("6666666666666666666666666666666666666666666666666666");
            System.out.println(user);
            List<Long> userAppreciateTravelList = new ArrayList<>();
            List<UserTravelAppreciate> userTravelAppreciates = userTravelAppreciateService.findAllUserTravelAppreciate(user.getId());
            for (int i=0;i<userTravelAppreciates.size();i++){
                userAppreciateTravelList.add(userTravelAppreciates.get(i).getAppreciatetravel_id());
            }
            System.out.println("集合: " + userTravelAppreciates);
            model.addAttribute("userAppreciateTravelList",userAppreciateTravelList);
        }
        model.addAttribute("Travel",travelInfoVOList);
        return "client/sightTravels";
    }
}
