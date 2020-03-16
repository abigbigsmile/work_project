package com.smile.WrittenExamination;

public class CompareVersion {

    public static void main(String[] args) {
        String s1 = "0.2.1";
        String s2 = "0.2.4";
        System.out.println(compareVersion(s1, s2));
    }

    public static int compareVersion(String s1, String s2){
        String[] ss1 = s1.trim().split("\\.");
        String[] ss2 = s2.trim().split("\\.");
        for(int i=0; i<3; i++){
            if(ss1[i].equals(ss2[i])) continue;
            else return Integer.valueOf(ss1[i])-Integer.valueOf(ss2[i]);
        }
        return 0;
    }


}
