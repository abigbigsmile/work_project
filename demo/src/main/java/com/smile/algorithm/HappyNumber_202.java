package com.smile.algorithm;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

    public static void main(String[] args) {
        System.out.println(isHappy(75));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while(set.add(n)){
            sum = 0;
            while(n != 0){
                sum += Math.pow(n%10, 2);
                n /= 10;
            }
            if(sum == 1)return true;
            n = sum;
        }
        return false;
    }
}
