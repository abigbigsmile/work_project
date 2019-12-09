package com.smile.algorithm_review.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath_71 {

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        if(path==null || path.isEmpty()) return "";
        Deque<String> stack = new ArrayDeque<>();
        String[] srr = path.split("/");
        for(String s : srr){
            switch (s){
                case "": case ".": break;
                case ".." : {
                    if(!stack.isEmpty())stack.pop();
                    break;
                }
                default:{
                    stack.push(s);
                }
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }

}
