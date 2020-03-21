package com.smile.nowcoder.second;

import com.smile.algorithm.TreeNode;

import java.util.ArrayList;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 11:11
 * @ModifiedBy smile
 */
public class TwentyFour {



    // 正确写法
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(root==null) return res;
        helper(res, new ArrayList(), root, target);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curList, TreeNode curNode, int cur){
        if(cur<0) return;
        curList.add(curNode.val);
        if(curNode.left==null && curNode.right==null && cur == curNode.val) {
            res.add(new ArrayList(curList));
        }else{
            if(curNode.left!=null) helper(res, curList, curNode.left, cur-curNode.val);
            if(curNode.right!=null) helper(res, curList, curNode.right, cur-curNode.val);
        }
        curList.remove(curList.size()-1);
    }


    //错误写法:curList.add(curNode.val);两次
    // 应该统一添加，统一删除再回溯
    public ArrayList<ArrayList<Integer>> FindPath_x(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(root==null) return res;
        helper_x(res, new ArrayList(), root, target);
        return res;
    }
    public void helper_x(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curList, TreeNode curNode, int cur){
        if(cur<0) return;
        if(curNode.left==null && curNode.right==null && cur == curNode.val) {
            curList.add(curNode.val);
            res.add(new ArrayList(curList));
        }
        curList.add(curNode.val);
        if(curNode.left!=null) helper_x(res, curList, curNode.left, cur-curNode.val);
        if(curNode.right!=null) helper_x(res, curList, curNode.right, cur-curNode.val);
        curList.remove(curList.size()-1);
    }

    //另一种写法
    public static ArrayList<ArrayList<Integer>> FindPath_xx(TreeNode root, int target) {
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
