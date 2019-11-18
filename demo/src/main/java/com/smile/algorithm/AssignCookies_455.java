package com.smile.algorithm;

import java.util.Arrays;

public class AssignCookies_455 {

    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {10,9,8,7};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        if(g.length==0 || s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gindex = 0;
        int sindex = 0;
        int count = 0;
        while(gindex<g.length && sindex<s.length){
            if(s[sindex] >= g[gindex]){
                sindex++;
                gindex++;
                count++;
            }else{
                sindex++;
            }
        }
        return count;
    }

}
