package com.smile.nowcoder.First;

import com.smile.algorithm.TreeNode;

import java.util.ArrayList;

public class FindPath {

    public static void main(String[] args) {
        Integer[] nums = {10,5,12,4,7};
        TreeNode root = TreeNode.createBinaryTree(nums, 0);
        ArrayList<ArrayList<Integer>> res = FindPath(root, 22);
        System.out.println();
    }


    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backTrack(root, target, 0, res, new ArrayList<>());
        return res;
    }

    public static void backTrack(TreeNode cur, int target, int curSum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path){
        if(cur==null || curSum>target) return;
        path.add(cur.val);
        if(cur.left==null && cur.right==null && curSum+cur.val==target) res.add(new ArrayList<>(path));
        else {
            backTrack(cur.left, target, curSum + cur.val, res, path);
            backTrack(cur.right, target, curSum + cur.val, res, path);
        }
        path.remove(path.size()-1);
    }
}
