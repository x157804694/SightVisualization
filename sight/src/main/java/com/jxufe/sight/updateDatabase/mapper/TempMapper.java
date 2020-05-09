package com.jxufe.sight.updateDatabase.mapper;

import com.jxufe.sight.updateDatabase.bean.SightInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TempMapper {
    //使用mybatis进行update操作时设置一个int类型返回值，但是这个返回值并不是受影响行数，而是match次数
    //所以需要在jdbc url上进行修改，在末尾加上一项?useAffectedRows=true，
    //这样一来返回值即受影响行数了。
    int updateInfo(@Param("sightId") String sightId,@Param("qunarPrice") String qunarPrice,@Param("saleCount") String saleCount);

    //查询t_sightinfo表
    int selectBySightId(@Param("sightId") String sightId);

    //向t_sightinfo表插入(除了zone字段)
    int insertSightInfo(@Param("sightInfoBean") SightInfoBean sightInfoBean);

    //向t_sightupdateinfo表插入(三个字段)
    int insertSightUpdateInfo(@Param("sightInfoBean") SightInfoBean sightInfoBean);

    //向t_sightmonthlysalecount表插入（sightId、saleCount、createDate）
    int insertMonthlysalecount(@Param("sightInfoBean") SightInfoBean sightInfoBean,@Param("createDate") String createDate);

    //更新t_sightupdateinfo
    int updateSightUpdateInfo(@Param("sightInfoBean") SightInfoBean sightInfoBean);

    //更新t_goodcomments
    int updateGoodcomments(@Param("sightId") String sightId,@Param("content_n") String content_n,@Param("content_a") String content_a);

    //向t_goodcomments插入
    int insertGoodcomments(@Param("sightId") String sightId,@Param("content_n") String content_n,@Param("content_a") String content_a);

    //更新t_badcomments
    int updateBadcomments(@Param("sightId") String sightId,@Param("content_n") String content_n,@Param("content_a") String content_a);

    //向t_badcomments插入
    int insertBadcomments(@Param("sightId") String sightId,@Param("content_n") String content_n,@Param("content_a") String content_a);

    //更新t_sightupdateinfo(goodCommentAmount、badCommentAmount、sumAmount三个字段)
    int updateSightUpdateInfoForCommentCount(@Param("sightId") String sightId,@Param("goodCommentAmount") String goodCommentAmount,@Param("badCommentAmount") String badCommentAmount,@Param("sumAmount") String sumAmount);
}
