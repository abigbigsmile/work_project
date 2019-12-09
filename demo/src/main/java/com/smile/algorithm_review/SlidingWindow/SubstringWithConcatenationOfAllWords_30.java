package com.smile.algorithm_review.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstringWithConcatenationOfAllWords_30 {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> res = findSubstring(s, words);
        System.out.println();
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s==null || words==null || words.length==0 || s.isEmpty()) return res;
        //用来保存words的单词
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(String word : words) wordMap.put(word, wordMap.getOrDefault(word, 0)+1);


        // 计算已经匹配的单词
        int len = words[0].length();
        for(int i=0; i<len; i++){
            int left = i;
            int counter = 0;
            //存放已经匹配的单词
            HashMap<String, Integer> existedMap = new HashMap<>();
            for(int right=i; right+len<=s.length(); right+=len){
                String curWord = s.substring(right, right+len);
                //如果存在这个单词
                if(wordMap.containsKey(curWord)){
                    existedMap.put(curWord, existedMap.getOrDefault(curWord, 0)+1);
                    if(existedMap.get(curWord)<=wordMap.get(curWord)) {
                        counter++;
                    }else {
                        //缩小窗口
                        while (existedMap.get(curWord) > wordMap.get(curWord)){
                            String temp = s.substring(left, left+len);
                            if(existedMap.containsKey(temp)){
                                existedMap.put(temp, existedMap.get(temp)-1);
                                if(existedMap.get(temp)<wordMap.get(temp)) counter--;
                            }
                            left += len;
                        }
                    }

                    //如果已经完全匹配
                    if(counter==words.length){
                        res.add(left);
                        String temp =  s.substring(left, left+len);
                        if(existedMap.containsKey(temp))existedMap.put(temp, existedMap.get(temp)-1);
                        left+=len;
                        counter--;
                    }
                }else{
                    //注意：如果[right, right+len]不匹配，left需要变成right+len
                    counter = 0;
                    existedMap.clear();
                    left = right+len;
                }
            }
        }
        return res;
    }
}
