package com.smile.nowcoder.second;

import java.util.Stack;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/16 23:41
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class Five {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()) return stack2.pop();
        else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

}
