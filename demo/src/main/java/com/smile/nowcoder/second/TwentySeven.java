package com.smile.nowcoder.second;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 14:55
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class TwentySeven {

    public static void main(String[] args) {
        String a = "ab";
        System.out.println(Permutation(a));
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList();
        if(str==null || str.length()==0) return res;
        char[] crr = str.toCharArray();
        Arrays.sort(crr);
        boolean[] visited = new boolean[str.length()];
        helper(res, crr, -1, new StringBuilder(), visited);
        return res;
    }


    public static void helper(ArrayList<String> res, char[] crr, int curIndex, StringBuilder sb, boolean[] visited){
        if(sb.length()==crr.length) {
            res.add(sb.toString());
            return;
        }
        for(int i=0; i<crr.length; i++) {
            if(visited[i] || (i>0 && crr[i]==crr[i-1] && visited[i-1])) continue;
            sb.append(crr[i]);
            visited[i] = true;
            helper(res, crr, i, sb, visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }

}
