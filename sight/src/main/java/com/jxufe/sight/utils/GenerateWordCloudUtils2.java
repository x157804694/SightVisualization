package com.jxufe.sight.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenerateWordCloudUtils2 {
    private static Logger logger= LoggerFactory.getLogger(GenerateWordCloudUtils2.class);
    public static  List<HashMap<String, String>> generate(String content){
        long startTime =  System.currentTimeMillis();
        List<HashMap<String, String>> jsondata = new ArrayList<>();
        if (content==null){
            HashMap<String,String> temp=new HashMap<>();
            temp.put("name","没有");
            temp.put("value","0");
            jsondata.add(temp);
            temp=new HashMap<>();
            temp.put("name","此类评论");
            temp.put("value","0");
            jsondata.add(temp);
            temp=new HashMap<>();
            temp.put("name","该景区");
            temp.put("value","0");
            jsondata.add(temp);
            return jsondata;
        }
        HashMap<String, Integer> words = new HashMap<>();
        String[] wordsString = content.split(" ");
        for (int i = 0; i < wordsString.length; i++) {
            int count=1;
            if (words.containsKey(wordsString[i])) {
                //更新
                count=words.get(wordsString[i])+1;
            }
            words.put(wordsString[i], count);
        }
        HashMap<String, String> wordData;
        for (String word : words.keySet()) {
            wordData = new HashMap<>();
            wordData.put("name", word);
            wordData.put("value", words.get(word)+"");
            jsondata.add(wordData);
        }
//        for (HashMap<String, String> hashMap : jsondata) {
//            System.out.println("{name:\""+hashMap.get("name")+"\",value:"+hashMap.get("value")+"},");
//        }
        System.out.println("解析时间："+(System.currentTimeMillis()-startTime));
        return jsondata;
    }
}
