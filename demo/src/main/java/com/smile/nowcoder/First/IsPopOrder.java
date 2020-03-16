package com.smile.nowcoder.First;

import java.util.Stack;

public class IsPopOrder {

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {2,1,3,5,4};
        System.out.println(IsPopOrder(pushA, popA));
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null && popA==null) return true;
        if(pushA==null || popA==null || pushA.length!=popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int num : pushA){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek()==popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}
