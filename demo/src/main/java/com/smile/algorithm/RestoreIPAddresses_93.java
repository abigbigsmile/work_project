package com.smile.algorithm;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {

    public static void main(String[] args) {
        String s = "25525511135";
        //List<String> res = restoreIpAddresses(s);
        List<String> res = restoreIpAddresses_x(s);
        System.out.println();
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for(int i=1; i<=3; i++){
            for(int j=1; j<=3; j++){
                for(int k=1; k<=3; k++){
                    if(i+j>=s.length() || i+j+k>=s.length()) continue;
                    String[] strs = new String[4];
                    strs[0] = s.substring(0,i);
                    strs[1] = s.substring(i, i+j);
                    strs[2] = s.substring(i+j, i+j+k);
                    strs[3] = s. substring(i+j+k, s.length());
                    boolean flag = true;
                    for(int x=0; x<4; x++){
                        if(strs[x].length()<=0 || strs[x].length()>=4 || (strs[x].startsWith("0")&&strs[x].length()>1)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag && Integer.valueOf(strs[0])<=255 && Integer.valueOf(strs[1])<=255 && Integer.valueOf(strs[2])<=255 && Integer.valueOf(strs[3])<=255){
                        String ans = String.join(".", strs);
                        res.add(ans);
                    }
                }
            }
        }
        return res;
    }

    //DFS解决
    public static List<String> restoreIpAddresses_x(String s){
        List<String> res = new ArrayList<>();
        helper(s, res, 0, "", 0);
        return res;
    }

    private static void helper(String s, List<String> res, int pos, String restored, int section) {
        //递归出口：当节数>4
        if(s.length()-pos > 3*(4-section)) return;
        if(section==4 && pos==s.length()){
            res.add(restored);
            return;
        }
        for(int i=1; i<4; i++){
            if(pos+i>s.length()) break;
            String cut = s.substring(pos, pos+i);
            if((cut.startsWith("0")&&cut.length()>1) || Integer.valueOf(cut) > 255) break;
            helper(s, res, pos+i, restored+(restored.isEmpty()? "": ".")+cut, section+1);
        }
    }

}
