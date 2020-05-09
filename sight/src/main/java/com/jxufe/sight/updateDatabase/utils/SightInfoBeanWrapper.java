package com.jxufe.sight.updateDatabase.utils;

import com.jxufe.sight.updateDatabase.bean.SightInfoBean;
import com.jxufe.sight.updateDatabase.exception.NotInitYetException;

public class SightInfoBeanWrapper {
    //字段名和索引号
//    public static HashMap<String,Integer> propertiesMap;
//    private static Field[] fields;
//
//    static {
//        propertiesMap=new HashMap<>();
//        try {
//            fields = Class.forName("com.jxufe.sight.updateDatabase.bean.SightInfoBean").getDeclaredFields();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static boolean init=false;
//
//    public static void initMap(String line){
//        String[] splits=line.split(",");
//        for(int i=0;i<splits.length;i++){
//            propertiesMap.put(splits[i].trim(),i);
//        }
//        init=true;//初始化了
//    }
    public static SightInfoBean wrap(String line) throws NotInitYetException, IllegalAccessException {
        String[] splits=line.split(",");
        SightInfoBean sightInfoBean=new SightInfoBean();
        int tag=0;
        sightInfoBean.setSightId((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setSightName((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setIntro((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setAddress((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setStar((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setQunarPrice((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setSaleCount((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setPoint((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setSightImgURL((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setProvince((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        tag++;
        sightInfoBean.setCity((splits[tag].equals("") || splits[tag].equals(" "))?null:splits[tag]);
        return sightInfoBean;
//        if(init){
//            String[] splits=line.split(",");
//            SightInfoBean sightInfoBean=new SightInfoBean();
//            for(Field f:fields){
//                f.setAccessible(true);
//                if(!Modifier.isStatic(f.getModifiers())){
//                    //设置值
//                    String value=splits[propertiesMap.get(f.getName())];
//                    if(value.equals("")  || value.equals(" ")){
//                        value=null;
//                    }
//                    f.set(sightInfoBean,value);
//                }
//            }
//            return sightInfoBean;
//        }else{
//            throw new NotInitYetException("没有初始化map");
//        }
    }
}
