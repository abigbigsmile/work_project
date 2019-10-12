package com.smile.algorithm;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class SumRootToLeafNumbers_129 {

    public static void main(String[] args) {

        String[] arr = {"1", "2", "3","4", "5","6", "7", "8","9"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        System.out.println(sumNumbers(root));
        System.out.println(sumNumbers_x(root));
        System.out.println();
    }

    private static int sumNumbers(TreeNode root) {
        int sum = 0;
        int res = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root, pre = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                sum = 10*sum + cur.val;
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            }
            if(cur.left==null && cur.right==null) res += sum; //到达叶子结点

            pre = cur;
            cur = null;
            stack.pop();
            sum /= 10;
        }
        return res;
    }

    private static int sumNumbers_x(TreeNode root){
        if(root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> nodePath = new Stack<>();
        nodeStack.push(root);
        nodePath.push(""+root.val);
        int runningSum = 0;
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            String currentPath = nodePath.pop();
            if(node.right != null){
                nodeStack.push(node.right);
                nodePath.push(currentPath + (""+node.right.val));
            }
            if(node.left != null){
                nodeStack.push(node.left);
                nodePath.push(currentPath+ (""+ node.left.val) );
            }
            if( node.left == null && node.right == null){
                runningSum = runningSum + Integer.valueOf(currentPath);
            }

        }
        return runningSum;
    }

}
