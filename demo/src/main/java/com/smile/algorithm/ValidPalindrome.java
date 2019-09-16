package com.smile.algorithm;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if(s.isEmpty())return true;
        int left = 0, right = s.length()-1;
        while(left < right){
            char chead=s.charAt(left);
            char ctail=s.charAt(right);
            if(!Character.isLetterOrDigit(chead))left++;
            else if(!Character.isLetterOrDigit(ctail))right--;
            else {
                if(Character.toLowerCase(chead) != Character.toLowerCase(ctail))return false;
                left++;
                right--;
            }
        }
        return true;
    }

    public static boolean isPalindrome_x(String s) {
        String pre = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        String rev = StringUtils.reverse(pre);
        return pre.equals(rev);
    }

    public static void reverseString(char[] s) {
        String str = String.valueOf(s);
        char[] temp = new StringBuffer(str).reverse().toString().toCharArray();
        s = Arrays.copyOf(temp,temp.length);
        System.out.println();

    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome_x(s));
        reverseString(new char[]{'h','e','l','l','o'});
    }

}
