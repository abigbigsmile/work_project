package com.smile.algorithm_review;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] crr = new int[128];
        int left=0, right=0;
        int res = Integer.MIN_VALUE;

        //crr[i]如果为负数表示已包含在窗口中，否则为0
        while(left<s.length()){
            //如果
            if(right<s.length() && crr[s.charAt(right)]==0){
                crr[s.charAt(right)]++;
                right++;
            }else{
                crr[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right-left);
        }
        return res==Integer.MIN_VALUE? 0:res;
    }
}
