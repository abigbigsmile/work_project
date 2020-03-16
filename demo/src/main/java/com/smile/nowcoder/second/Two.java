package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/16 22:10
 * @ModifiedBy smile
 */
public class Two {

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are the world")));
        System.out.println(replaceSpace_x(new StringBuffer("we are the world")));
        System.out.println(replaceSpace_xx(new StringBuffer("we are the world")));
    }

    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    /**
     * 思路：先算空格数，然后从后往前判断
     * @param str
     * @return
     */
    public static String replaceSpace_x(StringBuffer str) {
        if(str == null) return null;
        String s = str.toString();
        int spaceNum = 0;
        for(int i=0; i<s.length(); i++) if(s.charAt(i)==' ') spaceNum++;
        int newLength = s.length() + spaceNum*2;
        int indexNew = newLength-1;
        int indexOld = s.length()-1;

        str.setLength(newLength); //这一步很重要

        while(indexOld>=0 && indexOld<newLength) {
            if(s.charAt(indexOld) == ' '){
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
                indexOld--;
            }else{
                str.setCharAt(indexNew--, s.charAt(indexOld--));
            }
        }
        return str.toString();
    }


    public static String replaceSpace_xx(StringBuffer str) {
        if(str == null) return null;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.toString().length(); i++){
            if(str.charAt(i)==' '){
                sb.append('2');
                sb.append('0');
                sb.append('%');
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
