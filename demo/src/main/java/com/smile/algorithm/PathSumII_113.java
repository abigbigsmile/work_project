package com.smile.algorithm;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII_113 {

    public static void main(String[] args) {
        String[] arr = {"1", "3", "7","6", "6","2"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        pathSum(root, 10);
        //pathSum_x(root, 10);
        //pathSum_x_nonRecursive(root, 10);
        System.out.println();
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        if(root.left==null && root.right==null && root.val==sum) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.push(root.val);
            lists.add(temp);
            return lists;
        }
        for(List list : pathSum(root.left, sum-root.val)){
            LinkedList<Integer> linkedList = (LinkedList)list;
            linkedList.push(root.val);
            lists.add(list);
        }
        for(List list : pathSum(root.right, sum-root.val)){
            LinkedList<Integer> linkedList = (LinkedList)list;
            linkedList.push(root.val);
            lists.add(list);
        }
        return lists;
    }

    //DFS遍历
    public static List<List<Integer>> pathSum_x(TreeNode root, int sum){
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        pathSumHelper_dfs(root, sum, res, cur);
        return res;
    }

    //递归实现DFS探索路径
    private static void pathSumHelper_dfs(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> cur){
        if(root == null) return ;
        cur.add(root.val);
        if(root.left==null && root.right==null && root.val==sum){
            res.add(new LinkedList<>(cur));
        }else{
            pathSumHelper_dfs(root.left, sum-root.val, res, cur);
            pathSumHelper_dfs(root.right, sum-root.val, res, cur);
        }
        cur.removeLast();
    }

    //迭代实现DFS（使用stack)
    public static List<List<Integer>> pathSum_x_nonRecursive(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int weight = 0;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null) {
                stack.push(cur);
                path.add(cur.val);
                weight += cur.val;
                cur = cur.left;
            }

            cur = stack.peek();
            //为什么需要添加cur.right != pre呢？防止cur是刚从右子树回溯回来的，又重新走向右子树
            if(cur.right != null && cur.right != pre){
                cur = cur.right;
                continue;
            }
            if(cur.left==null && cur.right==null && weight==sum) res.add(new ArrayList<>(path));

            pre = cur;
            weight -= cur.val;
            path.remove(path.size()-1);
            stack.pop();
            cur = null;
        }
        return res;
    }
}
