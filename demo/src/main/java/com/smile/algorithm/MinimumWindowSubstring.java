package com.smile.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow_x("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow_xx("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        int left = 0;
        int pos = 0;
        String minStr = s;
        while(left < s.length()){
            if(pos < s.length() && !contain(s.substring(left, pos), t)){
                pos++;
            }else{
                left ++;
            }
            if(contain(s.substring(left, pos), t))minStr = minStr.length()>s.substring(left, pos).length()? s.substring(left, pos):minStr;
        }
        if(!minStr.contains(t) && minStr.equals(s))return "";
        return minStr;
    }
    public static boolean contain(String x, String y){
        for(int i=0; i<y.length(); i++){
            if(!x.contains(String.valueOf(y.charAt(i))))return false;
        }
        return true;
    }

    //时间复杂度O(n)
    public static String minWindow_x(String S, String T) {
        int[] map = new int[128];
        //init map, 记录T中每个元素出现的次数
        for(int i = 0; i < T.length(); i++) {
            map[T.charAt(i)]++;
        }

        // begin end两个指针指向窗口的首位，d记录窗口的长度， counter记录T中还有几个字符没被窗口包含
        int begin = 0, end = 0, d = Integer.MAX_VALUE, counter = T.length(), head = 0;
        // end指针一直向后遍历
        while(end < S.length()) {
            // map[] > 0 说明该字符在T中出现，counter-- 表示对应的字符被包含在了窗口，counter--, 如果s中的字符没有在T中出现，则map[]中对应的字符-1后变为负值
            if(map[S.charAt(end++)]-- > 0) {
                counter--;
            }
            // 当counter==0时，说明窗口已经包含了T中的所有字符
            while (counter == 0) {
                if(end - begin < d)  {
                    d = end - (head = begin);
                }
                //包含 ==0； 不包含 <0
                if(map[S.charAt(begin++)]++ == 0) {  // begin开始后移，继续向后寻找。如果begin后移后指向的字符在map中==0，表示是在T中出现的，如果没有出现，map[]中的值会是负值。
                    counter++;                      // 在T中的某个字符从窗口中移除，所以counter++。
                }
            }
        }
        return d==Integer.MAX_VALUE ? "" :S.substring(head, head+d);
    }

    public static String minWindow_xx(String s, String t){
        int[] arr = new int[128];//用于记录字符串t中的所有字符
        for(char c : t.toCharArray())arr[c]++;
        //left和pos分别表示滑动窗口的左右边界，d表示窗口大小，counter计数器用于计数窗口是否包含t中的所有字符
        int left=0, pos=0, d=Integer.MAX_VALUE, counter=t.length();
        int head = 0;
        //遍历字符串s
        while(pos < s.length()){
            if(arr[s.charAt(pos++)]-- > 0){//大于0表示pos对应的字符在arr中存在
                counter--;
            }
            //counter==0表示此时窗口已包括arr数组(即字符串t)的所有字符
            while(counter==0){
                if(pos - left < d){
                    d = pos - left; //d表示窗口大小
                    head = left;
                }
                if(arr[s.charAt(left++)]++ == 0){ //==0表示left对应的字符存在与字符串t
                    counter++;
                }
            }
        }
        return d==Integer.MAX_VALUE? "" : s.substring(head, head+d);
    }
}
