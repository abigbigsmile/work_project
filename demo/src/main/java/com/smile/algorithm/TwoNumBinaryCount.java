package com.smile.algorithm;

public class TwoNumBinaryCount {

    public static void main(String[] args) {
//        System.out.println(countBitDiff(1999, 2299));
        System.out.println(countBitDiff_x(19, 2299));
//        System.out.println(01&1);
    }

    public static int countBitDiff(int m, int n) {
        String ms = Integer.toBinaryString(m);
        String ns = Integer.toBinaryString(n);
        int count = 0;
        int i;
        for(i=0; i<ms.length()&&i<ns.length(); i++){
            if(ms.charAt(i) != ns.charAt(i))count++;
        }
        if(i == ms.length()){
            while(i<ns.length()){
                count++;
                i++;
            }
        }else if(i == ns.length()){
            while(i<ms.length()){
                count++;
                i++;
            }
        }else;

        return count;
    }


    public static int countBitDiff_x(int m, int n) {
        //  异或
        int k = m ^ n;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((k >> i) & 1) != 0)
                count++;
        }
        return count;
    }

}
