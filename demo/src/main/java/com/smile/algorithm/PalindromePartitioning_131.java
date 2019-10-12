package com.smile.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public static void main(String[] args) {
        String s = "bb";
        List<List<String>> res = partition(s);
        List<List<String>> ress = partition_x(s);
        System.out.println();
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.isEmpty()) return res;
        List<String> list = new ArrayList<>();
        helper(s, res, list, 0);
        return res;
    }

    public static void helper(String s, List<List<String>> res, List<String> list, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=pos;i<s.length(); i++){
            String cut = s.substring(pos, i+1);
            if(ispalindrome(cut)){
                list.add(cut);
                helper(s, res, list, i+1);
                list.remove(cut);
            }
        }
    }

    public static boolean ispalindrome(String s){
        String rev = new StringBuffer(s).reverse().toString();
        return s.equals(rev);
    }

    //判断是否为回文
    private boolean checkPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static List<List<String>> partition_x(String s) {
        List<List<String>> res = new ArrayList<>();
        //递归出口
        if(s == null || s.isEmpty()) return res;
        if(ispalindrome(s)){
            List<String> list = new ArrayList<>();
            list.add(s);
            res.add(list);
            //return res; 这里一定要注意，不能return
        }
        for(int i=1; i<s.length(); i++){
            String cut = s.substring(0, i);
            if(ispalindrome(cut)){
                List<List<String>> back = partition(s.substring(i));
                for(List<String> temp : back){
                    temp.add(0, cut);
                }
                res.addAll(back);
            }
        }
        return res;


    }

}
