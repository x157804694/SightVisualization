package com.jxufe.sight;

import com.github.pagehelper.PageHelper;
import com.jxufe.sight.web.client.SightBasicInfoController;
import org.junit.Test;
import org.springframework.web.context.request.RequestAttributes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class T1 {
    @Test
    public void t1(){
        System.out.println(RequestAttributes.class.getClassLoader());
        System.out.println(SightBasicInfoController.class.getClassLoader());
        System.out.println(PageHelper.class.getClassLoader());
    }
    private native void start0();
    @Test
    public void t2() throws IOException, InterruptedException {
        //开启一个进程执行命令脚本
//        Runtime.getRuntime().exec("notepad.exe");//执行打开记事本的命令

        //在java中，RunTime.getRuntime().exec()实现了调用命令脚本，会开启一个进程。
        //Process对象可以得到之前开启的进程的运行结果，还可以操作进程的输入输出流。
        String pythonFile="D:\\桌面文件站\\实训课\\pyInterface\\wordcloud05.py";
        String[] cmdArray=new String[]{"python",pythonFile,"arg1","arg2","arg3"};
        Process process=Runtime.getRuntime().exec(cmdArray);
        //经典3连：字节流-->字符流-->缓冲流
        BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
        String resultLine=null;
        while ((resultLine=reader.readLine())!=null){
            System.out.println(resultLine);
        }
        BufferedReader reader1=new BufferedReader(new InputStreamReader(process.getErrorStream(),"gbk"));
        String resultLine1=null;
        while ((resultLine1=reader1.readLine())!=null){
            System.out.println(resultLine1);
        }
        reader.close();
        int re = process.waitFor();//返回值为0表示我们调用python脚本成功
        System.out.println(re);
    }
    @Test
    public void test(){
        List<String> list= Arrays.asList("python","123","456");
        list.add("1231");
        System.out.println("hhh");
    }

    @Test
    public void sort(){
        String s1="江西";
        String s2="湖北";
        String s3="江吸";

        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s1));
        System.out.println(s1.compareTo(s3));
    }
}
