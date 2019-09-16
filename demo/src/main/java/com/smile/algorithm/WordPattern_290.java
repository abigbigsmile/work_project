package com.smile.algorithm;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {

    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length != pattern.length())return false;
        Map map = new HashMap<>();
        //注意：i的类型必须为Integer,这里涉及jvm对于Integer的缓存机制
        //当map的泛型为Map<String, Integer>时，put("string", 1)会自动装箱，即调用Integer.valueOf(1)转为包装类再put进map
        //而当-128 < int值 < 127时，会从缓存中的静态数组中取，而超出后则会new
        //从而当时map.put(strs[i], i) 和 map.put(pattern.charAt(i), i)返回的包装类比较发生变化
        for(Integer i=0; i<strs.length; i++){
            if(map.put(strs[i], i) != map.put(pattern.charAt(i), i))return false;
        }
        return true;

    }
}
