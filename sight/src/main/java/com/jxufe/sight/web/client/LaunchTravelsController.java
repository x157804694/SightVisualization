package com.jxufe.sight.web.client;

import com.jxufe.sight.service.TravelImgService;
import com.jxufe.sight.service.TravelService;
import com.jxufe.sight.vo.TravelImgs;
import com.jxufe.sight.vo.TravelInfoVO;
import com.jxufe.sight.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class LaunchTravelsController {

    @Autowired
    private TravelService travelService;
    @Autowired
    private TravelImgService travelImgService;

    @RequestMapping("/t_travels")
    public String travels(HttpSession session){
        if (session.getAttribute("list") != null){
            session.removeAttribute("list");
        }
        return "client/t_travels";
    }

    @PostMapping("/launchTravels")
    public String launchTravels(TravelInfoVO travelInfoVO,HttpSession session){
        travelInfoVO.setUserInfoVO((UserInfoVO) session.getAttribute("user"));
        Long travelId = travelService.saveTravel(travelInfoVO);
        travelId = travelInfoVO.getId();
        ArrayList list = (ArrayList) session.getAttribute("list");
        if(list != null){
            TravelImgs travelImgs = new TravelImgs();
            for (int i=0;i<list.size();i++){
                travelImgs.setImg_url(list.get(i).toString());
                travelImgs.setTravel_id(travelId);
                travelImgService.savetravelImg(travelImgs);
            }
        }
        return "redirect:/sighttravels";
    }
}
