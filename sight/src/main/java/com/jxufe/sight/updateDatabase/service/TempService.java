package com.jxufe.sight.updateDatabase.service;

import com.jxufe.sight.updateDatabase.bean.SightInfoBean;

public interface TempService {
    //更新t_sightinfo、t_sightupdateinfo、t_sightmonthlysalecount
    void operation1(SightInfoBean sightInfoBean);

    //更新t_goodcomments
    void operation2(String sightId,String content_n,String content_a);

    //更新t_badcomments
    void operation3(String sightId,String content_n,String content_a);

    //更新t_sightupdateinfo(goodCommentAmount、badCommentAmount、sumAmount三个字段)
    void operation4(String sightId,String goodCommentAmount,String badCommentAmount,String sumAmount);
}
