package com.smile.algorithm;

public class RemoveAllAdjacentDuplicatesInStringII_5206 {
    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        System.out.println(removeDuplicates(s, 2));
    }

    public static String removeDuplicates(String s, int k) {
        int left = 0;
        StringBuilder sb = new StringBuilder();
        while(left+k <= s.length()){
            int curPos = left;
            int i=1;
            for(; i<k; i++) if(left+i < s.length() && s.charAt(left+i) != s.charAt(left))break;
            if(i == k) {
                sb.append(s.substring(0, curPos));
                sb.append(s.substring(left+i));
                s = sb.toString();
                left = 0;
            }else{
                left = left + i;
            }
            sb.setLength(0);
        }
        return s;
    }
}
