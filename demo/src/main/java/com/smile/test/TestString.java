package com.smile.test;

public class TestString {

    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = s1.intern();
        String s3 = new String("abc");
        String s4 = s3.intern();
        System.out.println(s4 == s3);
    }
}
