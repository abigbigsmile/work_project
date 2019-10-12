package com.smile.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println();
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] mapper = {
                "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        StringBuilder sb = new StringBuilder();
        //helper(digits, res, mapper, 0, "");
        helper_x(digits, res, mapper, 0, sb);
        return res;

    }

    public static void helper(String digits, List<String> res, String[] mapper, int index, String sb){
        if(index == digits.length()){
            res.add(sb);
            return;
        }
        char c = digits.charAt(index);
        int mapIndex = Integer.valueOf(String.valueOf(c));
        for(int i=0; i<mapper[mapIndex].length(); i++){
            helper(digits, res, mapper, index+1, sb + mapper[mapIndex].charAt(i));
        }
        return;
    }

    public static void helper_x(String digits, List<String> res, String[] mapper, int index, StringBuilder sb){
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        int mapIndex = Integer.valueOf(String.valueOf(c));
        for(int i=0; i<mapper[mapIndex].length(); i++){
            helper_x(digits, res, mapper, index+1, sb.append(String.valueOf(mapper[mapIndex].charAt(i))));
            sb.setLength(sb.length()-1);
        }
        return;
    }
}
