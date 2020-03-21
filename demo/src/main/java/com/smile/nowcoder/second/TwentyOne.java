package com.smile.nowcoder.second;

import java.util.Stack;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 0:57
 * @ModifiedBy smile
 */
public class TwentyOne {
    
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || popA==null || pushA.length==0 || popA.length==0) return false;
        Stack<Integer> stack = new Stack();
        int popIndex = 0;
        for(int num : pushA){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

}
