package com.smile.nowcoder.First;

import java.util.*;

public class Permutation {

    public static void main(String[] args) {
        String str = "abcde";
//        ArrayList<String> res = Permutation(str);
        ArrayList<String> res = Permutation_x(str);
        System.out.println();
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str==null  || str.length()==0) return res;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper(chars, res, new StringBuilder(), 0, new boolean[str.length()]);
        return res;
    }
    public static void helper(char[] chars, ArrayList<String> res, StringBuilder sb, int count, boolean[] visited){
        if(count==chars.length){
            res.add(sb.toString());
            return;
        }
        for(int i=0; i<chars.length; i++){
            if(i>0 && !visited[i-1] && chars[i]==chars[i-1] )continue;
            if(!visited[i]){
                visited[i] = true;
                sb.append(chars[i]);
                helper(chars, res, sb, count+1, visited);
                sb.delete(sb.length()-1, sb.length());
                visited[i] = false;
            }
        }
    }


    public static ArrayList<String> Permutation_x(String str){

        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    private static void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }
    private static void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
