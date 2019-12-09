package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6};
        TreeNode root = TreeNode.createBinaryTree(nums, 0);
//        List<List<Integer>> res = levelOrder(root);
        List<List<Integer>> res = levelOrder_x(root);
        System.out.println();
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while(size-->0){
                TreeNode cur = queue.poll();
                levelList.add(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            res.add(levelList);
        }
        return res;
    }



    // 递归：DFS算法
    public static List<List<Integer>> levelOrder_x(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(res, root, 0);
        return res;
    }
    public static void dfsHelper(List<List<Integer>> res, TreeNode root, int level){
        if(root==null) return;
        if(level>=res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        dfsHelper(res, root.left, level+1);
        dfsHelper(res, root.right, level+1);
    }


}
