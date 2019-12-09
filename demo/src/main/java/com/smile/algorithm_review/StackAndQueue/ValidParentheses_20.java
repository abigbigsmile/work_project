package com.smile.algorithm_review.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses_20 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        LinkedList<Character> leftStack = new LinkedList<>();
        char[] crr = s.toCharArray();
        for(char c : crr){
            if(c=='(' || c=='[' || c=='{') leftStack.push(c);
            else {
                if(leftStack.isEmpty())return false;
                char left = leftStack.pop();
                if((left=='('&&c!=')') || (left=='['&&c!=']') || (left=='{'&&c!='}')) return false;
            }
        }
        return true;
    }


    public static boolean isValid_x(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid_xx(String s) {
        if ((s.length() & 1) == 1) return false;
        else {
            Deque<Character> p = new ArrayDeque<>(s.length());
            for (int i = 0; i < s.length(); i++)
                switch (s.charAt(i)) {
                    case '(':
                        p.push(')');
                        break;
                    case '{':
                        p.push('}');
                        break;
                    case '[':
                        p.push(']');
                        break;
                    case ')':
                    case '}':
                    case ']':
                        if (p.isEmpty() || p.pop() != s.charAt(i)) return false;
                }
            return p.isEmpty();
        }
    }
}
