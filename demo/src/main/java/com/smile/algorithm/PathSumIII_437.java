package com.smile.algorithm;

import java.util.HashMap;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

public class PathSumIII_437 {

    public static void main(String[] args) {
        String[] arr = {"10","5","-3","3","2","99","11","3","-2","77","1"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        pathSum(root, 8);
        System.out.println();
    }

    /**
     * 该解法真是将DFS吃透了。
     * 首先有一个引题，那便是给定一个数组，有正有负有0，如何找到子数组和为target的所有子数组个数？
     * 利用HashMap,将从0索引到任一个位置的数组和都加入map中，假设此时数组中已经有了 0~0， 0~1…0~i -1范围的子数组和，那么当遍历到 i位置时，此时 0~i的数组和为curSum，检查map中是否存在curSum - target 值，若有，则说明从数组的某一位置到i位置，这形成的子数组和便是target。
     * 为了不遗漏从0索引开始的位置，初始时，将<0, -1>放入map中。key为路径和，value为索引。
     * 这样便是O(N)下找到了所有子数组和为sum的子数组。
     * 回到该题，如果我们将数中的一条路径看做数组的话，那么便是同样的情况，为了统计路径个个数，key存从根节点到某中间节点的路径和，value存出现该路径和的次数。
     * 可是这是一颗二叉树，存在多条从根到 叶子节点的路径，那么只能通过 DFS + 回溯来控制map，保证map中始终维持的是一条从根到叶子节点的路径相关路径和信息。具体见实现。
     * 时间复杂度：O(N)
     * @param root
     * @param sum
     * @return
     */
    public static int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1); //增加(0,1)是为了不忽略根结点
        return helper(root, 0, sum, preSum);
    }

    public static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        //这里有可能会找到多条子路径符合currSum-target在preSum中找到
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
