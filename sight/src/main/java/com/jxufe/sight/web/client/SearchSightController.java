package com.jxufe.sight.web.client;

import com.jxufe.sight.service.SightBasicInfoService;
import com.jxufe.sight.utils.DefaultPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchSightController {
    private SightBasicInfoService sightBasicInfoService;

    public SearchSightController() {
    }

    @Autowired
    public SearchSightController(SightBasicInfoService sightBasicInfoService) {
        this.sightBasicInfoService = sightBasicInfoService;
    }

    @GetMapping("/search")
    public String querySights(String sightName, Double start, Double end, Integer order,
                              @RequestParam(required = false,defaultValue = "1")int page,
                              @RequestParam(required = false , defaultValue = DefaultPageInfo.SIGHT_PAGESIZE_STR)int pageSize,
                              @RequestParam(required = false,defaultValue = "false") boolean turnPage,
                              Model model){

        model.addAttribute("searchSightName",sightName);
        model.addAttribute("page",sightBasicInfoService.search(sightName.trim(),start,end,order,page,pageSize));
        if (turnPage){//正在翻页
            System.out.println("--------------------search-sightsContainer------------------");
            return "client/search::sightsContainer";
        }else{
            if (start==null && end==null && order==null){//一个新的查询
                System.out.println("----------------------search-------------------");
                return "client/search";
            }else{//输入价格区间或点击排序时
                System.out.println("----------------------search-sightsAndPageContainer-------------------");
                return "client/search::sightsAndPageContainer";
            }
        }
    }

}
