package com.smile.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {

    public static void main(String[] args) {
        System.out.println(isValid("[]}"));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char cp = stack.pop();
                if(cp == '(' && c != ')')return false;
                else if(cp == '[' && c != ']') return false;
                else if(cp == '{' && c != '}') return false;
                else;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    //使用hashmap，和stack.peek();
    public static boolean isValid_x(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{') stack.push(c);
            else if(!stack.isEmpty() && map.get(stack.peek()) == c) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
