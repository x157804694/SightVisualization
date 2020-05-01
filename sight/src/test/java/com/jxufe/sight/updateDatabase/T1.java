package com.jxufe.sight.updateDatabase;

import com.jxufe.sight.SightApplication;
import com.jxufe.sight.updateDatabase.bean.SightInfoBean;
import com.jxufe.sight.updateDatabase.exception.NotInitYetException;
import com.jxufe.sight.updateDatabase.service.TempService;
import com.jxufe.sight.updateDatabase.service.serviceImp.TempServiceImp;
import com.jxufe.sight.updateDatabase.utils.SightInfoBeanWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SightApplication.class)
public class T1 {
    @Autowired
    TempService tempService;

    //更新t_sightinfo、t_sightupdateinfo、t_sightmonthlysalecount
    @Test
    public void t1() throws IOException, NotInitYetException, IllegalAccessException {
        String path="D:\\桌面文件站\\实训课\\数据爬取集合";
        File parentDirection=new File(path);
        FileFilter fileFilter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                String s = pathname.getName().toLowerCase();

                if(s.endsWith(".csv")){
                    return true;
                }
                return false;
            }
        };
        File[] files=parentDirection.listFiles(fileFilter);
        System.out.println("files.length="+files.length);
        int tag=0;
        for(File file:files){
            System.out.println("------------"+(++tag)+","+file.getName()+"--------------");
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            String line=null;
            int readTag=0;
            while ((line=bufferedReader.readLine())!=null){
                readTag++;
                SightInfoBean sightInfoBean= SightInfoBeanWrapper.wrap(line);
                tempService.operation1(sightInfoBean);
            }
            System.out.println("readTag="+readTag);
        }
    }

    //更新t_goodcomments
    @Test
    public void t2() throws IllegalAccessException, IOException {
        File parentDirection=new File("E:\\pycharm-workspace\\spiderOfQunaer\\pyFiles\\goodComment");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String s = pathname.getName().toLowerCase();
                if(s.endsWith(".csv")){
                    return true;
                }
                return false;
            }
        };
        File[] files=parentDirection.listFiles(fileFilter);
        System.out.println("files.length="+files.length);
        int tag=0;
        for(File file:files){
            System.out.println("------------"+(++tag)+","+file.getName()+"--------------");
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            String line=null;
            int readTag=0;
            while ((line=bufferedReader.readLine())!=null){
                readTag++;
                String[] splits=line.split(",");
                String content_n=(splits[1].equals("") || splits[1].equals(" "))?null:splits[1];
                String content_a=(splits[2].equals("") || splits[2].equals(" "))?null:splits[2];
                tempService.operation2(splits[0],content_n,content_a);
            }
            System.out.println("readTag="+readTag);
        }
        System.out.println("unmatched="+ TempServiceImp.unmatchedForoperation2);
    }

    //更新t_badcomments
    @Test
    public void t3() throws IllegalAccessException, IOException {
        File parentDirection=new File("E:\\pycharm-workspace\\spiderOfQunaer\\pyFiles\\badComment");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String s = pathname.getName().toLowerCase();
                if(s.endsWith(".csv")){
                    return true;
                }
                return false;
            }
        };
        File[] files=parentDirection.listFiles(fileFilter);
        System.out.println("files.length="+files.length);
        int tag=0;
        for(File file:files){
            System.out.println("------------"+(++tag)+","+file.getName()+"--------------");
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            String line=null;
            int readTag=0;
            while ((line=bufferedReader.readLine())!=null){
                readTag++;
                String[] splits=line.split(",");
                String content_n=(splits[1].equals("") || splits[1].equals(" "))?null:splits[1];
                String content_a=(splits[2].equals("") || splits[2].equals(" "))?null:splits[2];
                tempService.operation3(splits[0],content_n,content_a);
            }
            System.out.println("readTag="+readTag);
        }
        System.out.println("unmatchedForoperation3="+ TempServiceImp.unmatchedForoperation3);
    }

    //更新t_sightupdateinfo(goodCommentAmount、badCommentAmount、sumAmount三个字段)
    @Test
    public void t4() throws IllegalAccessException, IOException {
        File parentDirection=new File("E:\\pycharm-workspace\\spiderOfQunaer\\pyFiles\\commentCount");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String s = pathname.getName().toLowerCase();
                if(s.endsWith(".csv")){
                    return true;
                }
                return false;
            }
        };
        File[] files=parentDirection.listFiles(fileFilter);
        System.out.println("files.length="+files.length);
        int tag=0;
        for(File file:files){
            System.out.println("------------"+(++tag)+","+file.getName()+"--------------");
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            String line=null;
            int readTag=0;
            while ((line=bufferedReader.readLine())!=null){
                readTag++;
                String[] splits=line.split(",");
                tempService.operation4(splits[0],splits[1],splits[2],splits[3]);
            }
            System.out.println("readTag="+readTag);
        }
        System.out.println("unmatchedForoperation4="+ TempServiceImp.unmatchedForoperation4);
    }
}
