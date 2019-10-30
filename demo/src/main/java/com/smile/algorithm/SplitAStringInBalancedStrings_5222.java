package com.smile.algorithm;

public class SplitAStringInBalancedStrings_5222 {

    public static void main(String[] args) {
        String s = "LLLLRRRR";
        //System.out.println(balancedStringSplit_x(s));
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        if(s==null || s.isEmpty() || s.length()%2!=0) return 0;
        int count = helper(s, 0);
        return count;
    }

    public static int balancedStringSplit_x(String s) {
        if(s==null || s.isEmpty() || s.length()%2!=0) return 0;
        int l = 0, r = 0;
        int count=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='L') l++;
            else r++;
            if(l!=0 && l==r) count++;
        }
        return count;
    }

    public static int helper(String s, int start){
        int count = 0;
        if(start==s.length()){
            return 0;
        }
        for(int i=1; i<s.length(); i++){
            String temp = s.substring(start, i);
            if(isBalancedString(temp)) count += helper(s, i);
        }
        return count;
    }

    public static boolean isBalancedString(String s){
        int left=0, right=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='L') left++;
            else right++;
        }
        return left==right;
    }
}
