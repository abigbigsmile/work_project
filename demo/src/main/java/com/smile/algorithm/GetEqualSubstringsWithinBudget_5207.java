package com.smile.algorithm;

public class GetEqualSubstringsWithinBudget_5207 {
    public static void main(String[] args) {
        String s="abcd", t="bcdf";
        System.out.println(equalSubstring(s, t, 1));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        if(maxCost == 0) return 1;
        int curCost = 0;
        int maxLength = 0;
        int left = 0, pos = 0;
        while(left < s.length()){
            if(pos < s.length() && curCost + Math.abs(s.charAt(pos) - t.charAt(pos)) <= maxCost) {
                curCost += Math.abs(s.charAt(pos) - t.charAt(pos));
                pos++;
            }else{
                curCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left ++;
            }
            maxLength = Math.max(maxLength, pos-left);
        }
        return maxLength;
    }
}
