package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 1:23
 * @ModifiedBy smile
 */

import com.smile.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。s
 */
public class TwentyTwo {

    // 标准层序遍历
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if(root==null) return res;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size-->0) {
                    TreeNode cur = queue.poll();
                    res.add(cur.val);
                    if(cur.left!=null) queue.offer(cur.left);
                    if(cur.right!=null) queue.offer(cur.right);
                }
            }
            return res;
        }
    }

}
