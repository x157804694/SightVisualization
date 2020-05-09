package com.jxufe.sight.updateDatabase.service.serviceImp;

import com.jxufe.sight.updateDatabase.bean.SightInfoBean;
import com.jxufe.sight.updateDatabase.mapper.TempMapper;
import com.jxufe.sight.updateDatabase.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TempServiceImp implements TempService {
    public static int unmatchedForoperation2=0;
    public static int unmatchedForoperation3=0;
    public static int unmatchedForoperation4=0;
    private TempMapper tempMapper;

    public TempServiceImp() {
    }

    @Autowired
    public TempServiceImp(TempMapper tempMapper) {
        this.tempMapper = tempMapper;
    }


    @Transactional
    @Override
    public void operation1(SightInfoBean sightInfoBean) {
        //先查询t_sightinfo表，查到了update t_sightupdateinfo表（代表是老景区）
        //没查到（新景区）：insert t_sightinfo和t_sightupdateinfo
        //不管有没有查到，都要insert t_sightmonthlysalecount表，存储当前月景区月销量
        boolean founded=true;
        String message="";
        int selectTag=tempMapper.selectBySightId(sightInfoBean.getSightId());
        if(selectTag==1){
            //查到了
            tempMapper.updateSightUpdateInfo(sightInfoBean);
            message+=sightInfoBean.getSightId()+"查到了,";
        }else{
            //没查到
            founded=false;
            message+=sightInfoBean.getSightId()+"没查到,";
            int insertTag1=tempMapper.insertSightInfo(sightInfoBean);
            message+="insertTag1="+insertTag1+",";
            int insertTag2=tempMapper.insertSightUpdateInfo(sightInfoBean);
            message+="insertTag2="+insertTag2+",";
        }
        int insertTag3=tempMapper.insertMonthlysalecount(sightInfoBean,"2020-04-01");
        message+="insertTag3="+insertTag3;
        if(founded==false){
            System.err.println(message);
        }else{
            System.out.println(message);
        }
    }

    @Transactional
    @Override
    public void operation2(String sightId, String content_n, String content_a) {
        //先update，若返回值为0，则没匹配到，就要插入
        String message="";
        int updateTag=tempMapper.updateGoodcomments(sightId,content_n,content_a);
        message+="updateTag="+updateTag+",";
        if(updateTag==0){
            unmatchedForoperation2++;
            //没匹配到
            int insertTag=tempMapper.insertGoodcomments(sightId,content_n,content_a);
            message+="insertTag="+insertTag;
            System.err.println(sightId+"没查到,"+message);
        }else{
            System.out.println(sightId+"查到了,"+message);
        }
    }

    @Transactional
    @Override
    public void operation3(String sightId, String content_n, String content_a) {
        //先update，若返回值为0，则没匹配到，就要插入
        String message="";
        int updateTag=tempMapper.updateBadcomments(sightId,content_n,content_a);
        message+="updateTag="+updateTag+",";
        if(updateTag==0){
            unmatchedForoperation3++;
            //没匹配到
            int insertTag=tempMapper.insertBadcomments(sightId,content_n,content_a);
            message+="insertTag="+insertTag;
            System.err.println(sightId+"没查到,"+message);
        }else{
            System.out.println(sightId+"查到了,"+message);
        }
    }

    @Override
    public void operation4(String sightId, String goodCommentAmount, String badCommentAmount, String sumAmount) {
        int updateTag=tempMapper.updateSightUpdateInfoForCommentCount(sightId,goodCommentAmount,badCommentAmount,sumAmount);
        if(updateTag==0){
            unmatchedForoperation4++;
            System.err.println(sightId+"没查到，updateTag="+updateTag);
        }else{
            System.out.println(sightId+"查到了，updateTag="+updateTag);
        }
    }

}
