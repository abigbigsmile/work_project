package com.smile.nowcoder.First;

public class GetUglyNumber_Solution {

    public static void main(String[] args) {
        int index = 20;
        System.out.println(GetUglyNumber_Solution(index));
        System.out.println(nthUglyNumber(index));
    }

    public static int GetUglyNumber_Solution(int index) {
        if(index==1) return 1;
        int count = 1;
        int number = 1;
        while(count < index){
            number++;
            if(isUglyNumber(number)){
                 System.out.print(number + " ");
                count++;
            }
        }
        return number;
    }
    //是否是丑数
    public static boolean isUglyNumber(int number){
        //所有因子(除了自身）
        for(int i=2; i<=Math.sqrt(number); i++){
            if(number%i==0){
                int another = number/i;
                if(isPrime(i) && i!=2 && i!=3 && i!=5) return false;
                if(isPrime(another) && another!=2 && another!=3 && another!=5) return false;
            }
        }
        if(isPrime(number) && number!=2 && number!=3 && number!=5) return false;
        return true;
    }

    //是否是质数
    public static boolean isPrime(int num){
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }


    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }


    public int nthUglyNumber_x(int n) {
        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for(int i = 1; i < nums.length; i++){
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if(nums[i] == nums[index2] * 2)
                index2++;
            if(nums[i] == nums[index3] * 3)
                index3++;
            if(nums[i] == nums[index5] * 5)
                index5++;
        }
        return nums[n - 1];
    }
}
