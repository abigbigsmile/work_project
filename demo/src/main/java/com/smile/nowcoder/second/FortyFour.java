package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 18:20
 * @ModifiedBy smile
 */

//翻转单词顺序列
public class FortyFour {

    /*
    题目描述
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     */


    public String ReverseSentence(String str) {
        String[] strs = str.trim().split(" ");
        int left = 0, right = strs.length-1;
        while(left < right){
            String temp = strs[left];
            strs[left] = strs[right];
            strs[right] = temp;

            left++;
            right--;
        }
        String resStr = String.join(" ", strs);
        return resStr;
    }

    //递归
    public String ReverseSentence_x(String str) {
        return str.lastIndexOf(" ")==-1? str : str.substring(str.lastIndexOf(" ")+1) + " " + ReverseSentence(str.substring(0, str.lastIndexOf(" ")));
    }

    public static void main(String[] args) {
        System.out.println("--" + "    ".trim().length()+"--");
    }

}
