package com.smile.nowcoder.second;

import com.smile.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 15:27
 * @ModifiedBy smile
 */
public class ThirtyEight {

    // 递归
    public int TreeDepth(TreeNode root) {
        if(root==null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right)+1;
    }

    // dfs
    public int TreeDepth_x(TreeNode root) {
        if(root==null) return 0;
        int res = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            res = Math.max(res, depth);
            if(node.left!=null){
                nodeStack.push(node.left);
                depthStack.push(depth+1);
            }
            if(node.right!=null){
                nodeStack.push(node.right);
                depthStack.push(depth+1);
            }
        }
        return res;
    }

    // BFS
    public int maxDepth_x(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = nodes.poll();
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
        }
        return depth;
    }


}
