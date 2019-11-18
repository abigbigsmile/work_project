package com.smile.algorithm_review;


/**
 * 双指针问题
 */
public class ValidPalindrome_125 {

    public static void main(String[] args) {
        String s = "0P";
//        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome_x(s));
    }


    public static boolean isPalindrome(String s) {
        if(s==null) return true;
        String replaceStr = s.replaceAll("[^a-zA-Z0-9]", "");
        return new StringBuilder(replaceStr).reverse().toString().equalsIgnoreCase(replaceStr);
    }

    public static boolean isPalindrome_x(String s) {
        if(s==null || s.isEmpty()) return true;
        int left = 0, right = s.length()-1;
        while(left<right){
            char chead = s.charAt(left);
            char ctail = s.charAt(right);
            if(!Character.isLetterOrDigit(chead)){
                left++;
            }else if(!Character.isLetterOrDigit(ctail)){
                right--;
            }else{
                if(Character.toLowerCase(chead)!=Character.toLowerCase(ctail)) return false;
                left++;
                right--;
            }
        }
        return true;
    }


}
