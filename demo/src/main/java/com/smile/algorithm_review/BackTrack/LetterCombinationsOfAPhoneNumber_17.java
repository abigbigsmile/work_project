package com.smile.algorithm_review.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {

    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
    }


    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.isEmpty()) return res;
        String[] keyBoard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, 0, res, "", keyBoard);
        return res;
    }

    public static void helper(String digits, int index, List<String> res, String curStr, String[] keyBoard){
        if(index==digits.length()){
            res.add(curStr);
            return ;
        }

        int cur = digits.charAt(index)-'0';
        for(int i=0; i<keyBoard[cur].length(); i++){
            helper(digits, index+1, res, curStr+keyBoard[cur].charAt(i), keyBoard);
        }
    }
}
