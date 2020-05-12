package com.jxufe.sight.web.client;

import com.jxufe.sight.bean.WordCloudsAccessPath;
import com.jxufe.sight.properties.WordCloudProperties;
import com.jxufe.sight.service.RecommendationService;
import com.jxufe.sight.service.SightCategoryService;
import com.jxufe.sight.service.SightCommentsService;
import com.jxufe.sight.utils.GenerateWordCloudUtils;
import com.jxufe.sight.utils.GenerateWordCloudUtils2;
import com.jxufe.sight.vo.SightCategory;
import com.jxufe.sight.vo.SightCommentsInfoVO;
import com.jxufe.sight.vo.UserClick;
import com.jxufe.sight.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/detail")
public class SightCommentsController {
    private SightCommentsService sightCommentsService;
    private WordCloudProperties wordCloudProperties;
    private RecommendationService recommendationService;
    private SightCategoryService sightCategoryService;

    public SightCommentsController() {
    }

    @Autowired
    public SightCommentsController(SightCommentsService sightCommentsService,RecommendationService recommendationService,SightCategoryService sightCategoryService) {
        this.sightCommentsService = sightCommentsService;
        this.recommendationService = recommendationService;
        this.sightCategoryService = sightCategoryService;
    }

    @GetMapping("")
    public String detail(String sightId, String sightName, String city, Model model, HttpSession session){
        model.addAttribute("sightId",sightId);
        model.addAttribute("sightName",sightName);
        model.addAttribute("city",city);

        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
//        点击查看景区后记录其点击的景区
        if (user!=null){
            UserClick userClick = new UserClick(user.getUsername(),sightId);
            SightCategory sightCategory = new SightCategory(sightId);
            recommendationService.saveClickNum(userClick);
            sightCategoryService.updateClickNum(sightCategory);
        }
        return "client/detail";
    }

    @GetMapping("/{sightId}")
    @ResponseBody
    public SightCommentsInfoVO data(@PathVariable("sightId") String sightId){
        SightCommentsInfoVO sightCommentsInfoVO=sightCommentsService.findDigitalData(sightId);
        return sightCommentsInfoVO;
    }

    @PostMapping("/picture/{sightId}/{tag}")
    @ResponseBody
    public List<HashMap<String,String>> getOnepicture2(@PathVariable("sightId") String sightId, @PathVariable("tag") int tag) throws IOException, InterruptedException {
        //tag:1,2,3,4。分别是好评形容词，好评名词，差评形容词，差评名词
        SightCommentsInfoVO sightCommentsInfoVO=sightCommentsService.findContent(sightId);
        if(tag==1){
            return GenerateWordCloudUtils2.generate(sightCommentsInfoVO.getGood_a());
        }else if(tag==2){
            return GenerateWordCloudUtils2.generate(sightCommentsInfoVO.getGood_n());
        }else if(tag==3){
            return GenerateWordCloudUtils2.generate(sightCommentsInfoVO.getBad_a());
        }else{
            return GenerateWordCloudUtils2.generate(sightCommentsInfoVO.getBad_n());
        }
    }

    //废弃代码
    @GetMapping("/picture/{sightId}/{tag}")
    @ResponseBody
    public String getOnepicture(@PathVariable("sightId") String sightId,@PathVariable("tag") int tag) throws IOException, InterruptedException {
        //tag:1,2,3,4。分别是好评形容词，好评名词，差评形容词，差评名词
        String mvcPath=wordCloudProperties.getAccessPath().substring(0,wordCloudProperties.getAccessPath().lastIndexOf("/")+1);
        String baseName=GenerateWordCloudUtils.generateFileName(sightId,tag);
        String fileName=baseName+".png";
        File file=new File(wordCloudProperties.getPicturesDirectory(), fileName);
        if (file.exists()){//存在
            //返回访问路径
            return mvcPath+fileName;
        }else{//不存在：1.没生成；2.真的没有
            SightCommentsInfoVO sightCommentsInfoVO=sightCommentsService.findContent(sightId);
            String content=getContent(sightCommentsInfoVO,tag);
            if(content==null){//真的没有
                //返回空词云图片
                return mvcPath+wordCloudProperties.getNullPictureName();
            }else{//没生成
                if(GenerateWordCloudUtils.generate(content,baseName,wordCloudProperties)==0){
                    //执行脚本成功
                    return mvcPath+fileName;
                }else{
                    //执行脚本失败
                    return mvcPath+wordCloudProperties.getErrorPictureName();
                }
            }
        }
    }

    //废弃代码
    public String getContent(SightCommentsInfoVO sightCommentsInfoVO,int tag){
        if(tag==1){
            return sightCommentsInfoVO.getGood_a();
        }else if(tag==2){
            return sightCommentsInfoVO.getGood_n();
        }else if(tag==3){
            return sightCommentsInfoVO.getBad_a();
        }else{
            return sightCommentsInfoVO.getBad_n();
        }
    }


    //废弃代码
    @GetMapping("/pictures/{sightId}")
    @ResponseBody
    public WordCloudsAccessPath getAllpicture(@PathVariable("sightId") String sightId) throws IOException, InterruptedException {
        //tag:1,2,3,4。分别是好评形容词，好评名词，差评形容词，差评名词
        String mvcPath=wordCloudProperties.getAccessPath().substring(0,wordCloudProperties.getAccessPath().lastIndexOf("/")+1);
        String fileName1=GenerateWordCloudUtils.generateFileNameForGoodA(sightId)+".png";
        String fileName2=GenerateWordCloudUtils.generateFileNameForGoodN(sightId)+".png";
        String fileName3=GenerateWordCloudUtils.generateFileNameForBadA(sightId)+".png";
        String fileName4=GenerateWordCloudUtils.generateFileNameForBadN(sightId)+".png";
        String parentPath=wordCloudProperties.getPicturesDirectory();
        File file1=new File(parentPath,fileName1);
        File file2=new File(parentPath,fileName2);
        File file3=new File(parentPath,fileName3);
        File file4=new File(parentPath,fileName4);
        boolean tag1=file1.exists();
        boolean tag2=file2.exists();
        boolean tag3=file3.exists();
        boolean tag4=file4.exists();
        WordCloudsAccessPath wordCloudsAccessPath=new WordCloudsAccessPath();
        if(tag1 || tag2 || tag3 || tag4){//有一个文件存在说明该景区生成过词云图片
            String nullPictureName=wordCloudProperties.getNullPictureName();
            wordCloudsAccessPath.setGoodaPath(tag1?(mvcPath+fileName1):(mvcPath+nullPictureName));
            wordCloudsAccessPath.setGoodnPath(tag2?(mvcPath+fileName2):(mvcPath+nullPictureName));
            wordCloudsAccessPath.setBadaPath(tag3?(mvcPath+fileName3):(mvcPath+nullPictureName));
            wordCloudsAccessPath.setBadnPath(tag4?(mvcPath+fileName4):(mvcPath+nullPictureName));
        }else{
            SightCommentsInfoVO sightCommentsInfoVO=sightCommentsService.findContent(sightId);
            if (sightCommentsInfoVO.isAllNull()){//该景区真的没有一个词云图片
                wordCloudsAccessPath.setAll(mvcPath+wordCloudProperties.getNullPictureName());
            }else{//该景区还未生成词云图片
                HashMap<String,String> map=new HashMap<>();
                wordCloudsAccessPath.setAll(mvcPath+wordCloudProperties.getNullPictureName());
                if(sightCommentsInfoVO.getGood_a()!=null){
                    map.put(fileName1,sightCommentsInfoVO.getGood_a());
                    wordCloudsAccessPath.setGoodaPath(mvcPath+fileName1);
                }
                if(sightCommentsInfoVO.getGood_n()!=null){
                    map.put(fileName2,sightCommentsInfoVO.getGood_n());
                    wordCloudsAccessPath.setGoodnPath(mvcPath+fileName2);
                }
                if(sightCommentsInfoVO.getBad_a()!=null){
                    map.put(fileName3,sightCommentsInfoVO.getBad_a());
                    wordCloudsAccessPath.setBadaPath(mvcPath+fileName3);
                }
                if(sightCommentsInfoVO.getBad_n()!=null){
                    map.put(fileName4,sightCommentsInfoVO.getBad_n());
                    wordCloudsAccessPath.setBadnPath(mvcPath+fileName4);
                }
                if(GenerateWordCloudUtils.generateAll(map,wordCloudProperties)==1){
                    //执行脚本失败
                    wordCloudsAccessPath.setAll(mvcPath+wordCloudProperties.getErrorPictureName());
                }
            }
        }
        return wordCloudsAccessPath;
    }
}
