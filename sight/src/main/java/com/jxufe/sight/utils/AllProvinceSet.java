package com.jxufe.sight.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//定义所有的合法省份
public class AllProvinceSet {
    public static Set<String> set;
    public static void init(List<String> list){
        set=new HashSet<>();
        set.add("全国");
        set.addAll(list);
    }
}
