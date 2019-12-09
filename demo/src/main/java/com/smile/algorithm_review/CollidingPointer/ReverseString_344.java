package com.smile.algorithm_review.CollidingPointer;


/**
 * 双指针问题
 */
public class ReverseString_344 {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        if(s.length==0) return;
        int left=0, right=s.length-1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }
}
