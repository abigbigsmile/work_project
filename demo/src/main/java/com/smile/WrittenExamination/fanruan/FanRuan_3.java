package com.smile.WrittenExamination.fanruan;

public class FanRuan_3 {

    public static void main(String[] args) {
        int num = 11, scale = 10;
        System.out.println(find(num, scale));
        System.out.println(find_x(num, scale));
    }


    public static int find(int num,int scale){
        int res=0;
        for(int i=1; i<=num; i++) {
            if (i < scale) res++;
            else {
                int sum = 0;
                int temp = i;
                while (temp > 0) {
                    sum++;
                    temp /= scale;
                }
                res += sum;
            }
        }
        return res;
    }

    public static int find_x(int num,int scale){
        int res=0;
        int pow = 1;
        for(int i=1; i<=num; i++) {
            if(i >= Math.pow(scale, pow)){
                pow++;
                i--;
            }
            else res += pow;
        }
        return res;
    }
}
