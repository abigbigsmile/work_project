package com.smile.WrittenExamination;

import java.util.Scanner;

public class Shein {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String reversedStr = reverseWords(str);
        System.out.println(reversedStr);
    }

    public static String reverseWords(String str){
        str.trim();
        String[] srr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=srr.length-1; i>=0; i--){
            if(i==0) sb.append(srr[i]);
            else sb.append(srr[i]+" ");
        }
        return sb.toString();
    }
}
