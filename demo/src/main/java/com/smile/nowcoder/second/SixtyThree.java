package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/21 17:36
 * @ModifiedBy smile
 */

import com.smile.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * 题目描述: 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4
 */
public class SixtyThree {

    //中序遍历
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null) return null;
        LinkedList<TreeNode> stack = new LinkedList();
        while(pRoot!=null || !stack.isEmpty()){
            if(pRoot!=null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }else{
                pRoot = stack.pop();
                k--;
                if(k==0) return pRoot;
                pRoot = pRoot.right;
            }
        }
        return null;
    }

}
