package com.smile.WrittenExamination.qianxin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QiAnXin_1 {

    public static void main(String[] args) {
        boolean exist = false;
        Scanner scanner = new Scanner(System.in);
        String[] pSrr = scanner.nextLine().trim().split(" ");
        String[] ppSrr = scanner.nextLine().trim().split(" ");
        int root = scanner.nextInt();
        int[] pArr = new int[pSrr.length+1];
        int[] ppArr = new int[ppSrr.length+1];
        for(int i=0; i<pSrr.length; i++) pArr[i] = Integer.valueOf(pSrr[i]);
        for(int i=0; i<ppSrr.length; i++) ppArr[i] = Integer.valueOf(ppSrr[i]);

        List<Integer> res = helper(ppArr, pArr, root);
        if(res!=null) System.out.println(res.size());
        else System.out.println(0);
    }

    public static List<Integer> helper(int[] ppArr, int[] pArr, int curPid){
        List<Integer> res = new ArrayList<Integer>();
        res.add(curPid);
        for (int i = 0; i < ppArr.length; i++) {
            if(ppArr[i]==curPid){
                res.addAll(helper(ppArr, pArr, pArr[i]));
            }
        }
        return res;
    }






}
