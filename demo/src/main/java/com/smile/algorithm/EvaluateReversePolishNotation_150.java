package com.smile.algorithm;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {

    public static void main(String[] args) {
        String[] strings = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(strings));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            switch (tokens[i]){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y - x);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y / x);
                    break;
                default:{
                    stack.push(Integer.valueOf(tokens[i]));
                }
            }
        }
        return stack.pop();
    }
}
