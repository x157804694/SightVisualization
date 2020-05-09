package com.jxufe.sight.web.client;

import com.jxufe.sight.service.TravelService;
import com.jxufe.sight.service.UserTravelAppreciateService;
import com.jxufe.sight.vo.TravelInfoVO;
import com.jxufe.sight.vo.UserInfoVO;
import com.jxufe.sight.vo.VoteInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class TravelAppreciateController {

    @Autowired
    private TravelService travelService;
    @Autowired
    private UserTravelAppreciateService userTravelAppreciateService;

    @ResponseBody
    @PostMapping("/addTravelAppreciateNum")
    public TravelInfoVO addTravelAppreciateNum(@RequestParam Long travelId, HttpSession session){
        System.out.println("投票ID = " + travelId);
        Long appreciateNum = travelService.findAppreciateNum(travelId) + 1;
        travelService.saveAppreciateNum(travelId,appreciateNum);
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        userTravelAppreciateService.saveUserTravelAppreciate(user.getId(),travelId);
        TravelInfoVO travelInfoVO = travelService.getTravel(travelId);
        return travelInfoVO;
    }

    @ResponseBody
    @PostMapping("/subTravelAppreciateNum")
    public TravelInfoVO subTravelAppreciateNum(@RequestParam Long travelId,HttpSession session){
        System.out.println("投票ID = " + travelId);
        Long appreciateNum = travelService.findAppreciateNum(travelId) - 1;
        travelService.saveAppreciateNum(travelId,appreciateNum);
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        userTravelAppreciateService.saveUserTravelAppreciate(user.getId(),travelId);
        TravelInfoVO travelInfoVO = travelService.getTravel(travelId);
        return travelInfoVO;
    }
}
