package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        System.out.println();
    }


    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s==null || s.isEmpty()) return res;
        hepler(s, 0, res, new ArrayList<>());
        return res;
    }


    public static void hepler(String s, int pos, List<List<String>> res, List<String> list){
        if(pos==s.length()) {
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i=1; pos+i<=s.length(); i++){
            String temp = s.substring(pos, pos+i);
            if(isPalindrome(temp)){
                list.add(temp);
                hepler(s, pos+i, res, list);
                list.remove(list.size()-1);
            }
        }
    }


    public static boolean isPalindrome(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
