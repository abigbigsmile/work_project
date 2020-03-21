package com.smile.nowcoder.second;

import com.smile.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/21 1:11
 * @ModifiedBy smile
 */


/**
 * 题目描述: 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class SixtyOne {


    //BFS
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot==null) return res;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int level =0;
        linkedList.offer(pRoot);
        while(!linkedList.isEmpty()){
            int size = linkedList.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(size-->0){
                TreeNode node = linkedList.poll();
                if(level%2==0){
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }
                if(node.left!=null) linkedList.offer(node.left);
                if(node.right!=null) linkedList.offer(node.right);
            }
            res.add(list);
            level++;
        }
        return res;
    }

    //递归深度搜索
    ArrayList<ArrayList<Integer> > Print_x(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot==null) return res;
        dfs(pRoot, res, 1);
        return res;

    }
    void dfs(TreeNode cur, ArrayList<ArrayList<Integer>> res, int level){
        if(level > res.size()) res.add(new ArrayList<Integer>());
        res.get(level-1).add(cur.val);
        if(cur.left!=null) dfs(cur.left, res, level+1);
        if(cur.right!=null) dfs(cur.right, res, level+1);
    }


}
