package com.jxufe.sight.web.client;

import com.jxufe.sight.exception.NotFoundException;
import com.jxufe.sight.service.SightBasicInfoService;
import com.jxufe.sight.utils.AllProvinceSet;
import com.jxufe.sight.utils.DefaultPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/querySights")
public class SightBasicInfoController {
    private SightBasicInfoService sightBasicInfoService;

    public SightBasicInfoController() {
    }

    @Autowired
    public SightBasicInfoController(SightBasicInfoService sightBasicInfoService) {
        this.sightBasicInfoService = sightBasicInfoService;
    }

    @GetMapping("/{province}")
    public String querySights(@PathVariable("province") String province, Double start, Double end, Integer order,
                              @RequestParam(required = false,defaultValue = "1")int page,
                              @RequestParam(required = false , defaultValue = DefaultPageInfo.SIGHT_PAGESIZE_STR)int pageSize,
                              @RequestParam(required = false,defaultValue = "false") boolean turnPage,
                              HttpServletRequest request, Model model) throws NotFoundException {
        //判断该province是否对应一个省份，否则抛出异常
        if (!AllProvinceSet.set.contains(province)){
            throw new NotFoundException(NotFoundException.NOT_FOUNG_PROVINCE);
        }
        //首先，必须确保start和end要么都null，要么都有值！
//        model.addAttribute("allProvince",AllProvinceSet.set);
        model.addAttribute("allProvince",getAllProvinces());
        model.addAttribute("page",sightBasicInfoService.findOnePage(province,start,end,order,page,pageSize));
        if (turnPage){//正在翻页
            System.out.println("--------------------sightsContainer------------------");
            return "client/main::sightsContainer";
        }else{
            if (start==null && end==null && order==null){//选择一个新的省份时
                //分页查询该省的前10个景区，按默认月销量排序
                model.addAttribute("currentProvince",province);
                if (request.getAttribute("index")!=null){//首页请求
                    System.out.println("----------------------main-------------------");
                    return "client/main";
                }else{
                    System.out.println("----------------------rightPanel-------------------");
                    return "client/main::rightPanel";
                }
            }else{//输入价格区间或点击排序时
                System.out.println("----------------------sightsAndPageContainer-------------------");
                //分页查询该省的前10个景区，动态条件：价格区间；排序字段。
                return "client/main::sightsAndPageContainer";
            }
        }
    }

    private ArrayList<String> getAllProvinces(){
        ArrayList<String> allProvinces=new ArrayList<>();
        allProvinces.add("全国");
        for(String province:AllProvinceSet.set){
            if(!province.equals("全国")){
                allProvinces.add(province);
            }
        }
        return allProvinces;
    }
}
