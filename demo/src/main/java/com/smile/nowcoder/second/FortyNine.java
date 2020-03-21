package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/20 0:27
 * @ModifiedBy smile
 */
public class FortyNine {

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483649"));
    }

    public static int StrToInt(String str) {
        if(str==null || str.length()==0) return 0;
        char[] crr = str.toCharArray();
        long res = 0;
        int s = crr[0]=='-'? -1:1;

        for(int i=(crr[0]=='-'||crr[0]=='+')? 1 : 0; i<crr.length; i++){
            int temp = crr[i]-'0';
            if(temp<0 || temp>9) return 0;
            res = res*10 + temp;
        }
        res = res*s;
        if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE) return 0;
        return (int)res;
    }

}
