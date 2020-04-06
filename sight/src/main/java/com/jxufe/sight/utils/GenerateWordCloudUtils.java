package com.jxufe.sight.utils;

import com.jxufe.sight.properties.WordCloudProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * 废弃
 */
public class GenerateWordCloudUtils {
    private static Logger logger= LoggerFactory.getLogger(GenerateWordCloudUtils.class);
    public static int generate(String words, String baseFileName,WordCloudProperties properties) throws IOException, InterruptedException {
        String[] cmdArray={"python",properties.getPyFilePath(),properties.getPicturesDirectory(),baseFileName,words};
        Process process=Runtime.getRuntime().exec(cmdArray);

//        打印成功执行的输出结果
//        BufferedReader reader1=new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
//        String resultLine1=null;
//        while ((resultLine1=reader1.readLine())!=null){
//            System.out.println(resultLine1);
//        }
//        reader1.close();

        int returnState=0;
        returnState=process.waitFor();//阻塞方法，会导致当前线程等待，直到子进程结束并返回退出状态。
        if (returnState==1){
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line=null;
            logger.error("---------执行脚本出错--------------");
            while ((line=bufferedReader.readLine())!=null){
                logger.error(line);
            }
            bufferedReader.close();
        }else{
            logger.info("-----------------脚本执行成功------------------");
        }
        return returnState;
    }
    //生成所有词云图片
    public static int generateAll(HashMap<String,String> map, WordCloudProperties properties) throws IOException, InterruptedException {
        //Arrays.asList返回的是固定长度的集合，且是Arrays的内部类，不是java.util.ArrayList
//        List<String> list= Arrays.asList("python",properties.getPyFilePath(),properties.getPicturesDirectory());
        List<String> list= new ArrayList<>();
        list.add("python");
        list.add(properties.getPyFilePath());
        list.add(properties.getPicturesDirectory());
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            String key=it.next();
            list.add(key);
            list.add(map.get(key));
        }
        //数组类型不能强制转换，强制类型转换只能针对单个对象。
        //报错：java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String
//        Process process=Runtime.getRuntime().exec((String[])list.toArray());
        //带参数的toArray方法指定了转换类型
        //-----------------------------------
//        File file=new File("D:\\pyInterface\\test\\test1.cmd");
//        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"gbk"));
//        int writeCount=0;
//        writer.write(list.get(0)+" ");
//        writer.write(list.get(1)+" ");
//        writer.write(list.get(2)+" ");
//        for(int i=3;i<list.size();i++){
//            writeCount++;
//            writer.write("\""+list.get(i)+"\" ");
//        }
//        writer.close();
//        System.out.println("writeCount="+(writeCount+3));
        Process process=Runtime.getRuntime().exec(list.toArray(new String[0]));

        int returnState=0;
        returnState=process.waitFor();//阻塞方法，会导致当前线程等待，直到子进程结束并返回退出状态。
        if (returnState==1){
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line=null;
            logger.error("---------执行脚本出错--------------");
            while ((line=bufferedReader.readLine())!=null){
                logger.error(line);
            }
            bufferedReader.close();
        }else{
            logger.info("-----------------脚本执行成功------------------");
        }
        return returnState;
    }
    public static String generateFileName(String sightId,int tag){
        if(tag==1){
            return generateFileNameForGoodA(sightId);
        }else if(tag==2){
            return generateFileNameForGoodN(sightId);
        }else if(tag==3){
            return generateFileNameForBadA(sightId);
        }else{
            return generateFileNameForBadN(sightId);
        }
    }
    public static String generateFileNameForGoodN(String sightId){
        return sightId+"_gn";
    }
    public static String generateFileNameForGoodA(String sightId){
        return sightId+"_ga";
    }
    public static String generateFileNameForBadN(String sightId){
        return sightId+"_bn";
    }
    public static String generateFileNameForBadA(String sightId){
        return sightId+"_ba";
    }
}
