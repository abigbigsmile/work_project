package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 0:37
 * @ModifiedBy smile
 */

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class Twenty {


    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()) stack2.push(node);
        else{
            if(node < stack2.peek()) stack2.push(node);
        }
    }

    public void pop() {
        if(stack1.isEmpty()) return;
        if(stack2.peek()==stack1.peek()) stack2.pop();
        stack1.pop();
    }

    public int top() {
        if(stack1.isEmpty()) throw new RuntimeException();
        return stack1.peek();
    }

    public int min() {
        if(stack2.isEmpty()) throw new RuntimeException();
        return stack2.peek();
    }

}
