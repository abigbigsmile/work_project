package com.smile.WrittenExamination;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

public class QingTingFM {

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(findIndex(arr, 134));
    }

    public static int longestSubString(String s) {
        return 0;
    }

    /**
     * 总共有n个元素，每次查找的区间大小就是n，n/2，n/4，…，n/2^k（接下来操作元素的剩余个数），其中k就是循环的次数。
     * 由于n/2^k取整后>=1，即令n/2^k=1，
     * 可得k=log2n,（是以2为底，n的对数），所以时间复杂度可以表示O()=O(logn)
     */

    public static int findIndex(int[] orderedArray, int key) {
        int left = 0, right = orderedArray.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(orderedArray[mid] == key) return mid;
            else if(orderedArray[mid] < key) left = mid+1;
            else right = mid - 1;
        }
        return -1;
    }


/*

    //LeetCode上的PathSumIII

    public static int findPathNum(TreeNode root, int sum) {
        int res = 0;
        res = helper(root, sum); //路径包含当前根结点
        res += helper(root.left, sum); //左子树
        res += helper(root.right, sum); //右子树
        return res;
    }

    //获取包含当前根结点值的树中找出路径数
    public static int helper(TreeNode root, int sum) {
        if(root == null) return 0;
        int res = 0;
        if(sum == root.val) res += 1;
        res += helper(root.left, sum-root.val);
        res += helper(root.right, sum-root.val);
        return res;
    }

*/

//还有一题就是实现LRU缓存

}
