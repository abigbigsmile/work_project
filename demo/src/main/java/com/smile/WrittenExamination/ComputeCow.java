package com.smile.WrittenExamination;

public class ComputeCow {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(calCow(n));
        System.out.println(calCow_x(n));
        System.out.println(calCow_xx(n));
    }

    public static int calCow(int n){
        int[] year = {0,1,0,0,0};
        for(int i=2; i<=n; i++){
            year[4] = year[4]+year[3];
            year[3] = year[2];//3岁
            year[2] = year[1];//2岁
            year[1] = year[4]; //1岁
        }
        int res = year[1]+year[2]+year[3]+year[4];
        return res;
    }

    /*
        F(n):表示第n年共有多少头牛

        F(n-1):表示第n-1年共有多少头牛

        F(n-3):表示第(n-3)年出生的母牛在第n年生的小母牛数
     */
    public static int calCow_x(int n){
        if(n==1 || n==2 || n==3) return 1;
        else return calCow_x(n-3) + calCow_x(n-1); //今年小牛总数量=今年新生的小牛+去年小牛的数量
    }

    public static int calCow_xx(int n){
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            if(i==1 || i==2 || i==3) dp[i] = 1;
            else dp[i]=dp[i-3]+dp[i-1];
        }
        return dp[n];
    }
}
