package com.smile.algorithm_review.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation_150 {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : tokens){
            switch (s){
                case "+": {
                    int one = stack.pop();
                    int two = stack.pop();
                    stack.push(one+two);
                    break;
                }
                case "-": {
                    int one = stack.pop();
                    int two = stack.pop();
                    stack.push(two-one);
                    break;
                }
                case "*": {
                    int one = stack.pop();
                    int two = stack.pop();
                    stack.push(one*two);
                    break;
                }
                case "/": {
                    int one = stack.pop();
                    int two = stack.pop();
                    stack.push(two/one);
                    break;
                }
                default: {
                    stack.push(Integer.valueOf(s));
                }
            }
        }
        return stack.pop();
    }
}
