package com.smile.nowcoder.First;

import com.smile.algorithm.TreeNode;

public class RebuildBinaryTree {

    public static void main(String[] args) {
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] in = {4,7,2,1,5,3,8,6};
//        TreeNode res = reConstructBinaryTree(pre, in);
//        System.out.println();
        System.out.println(Integer.toBinaryString(5));
    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = createBinaryTreeByPreIn(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }

    public static TreeNode createBinaryTreeByPreIn(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if(startPre>endPre || startIn>endIn) return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for(int i=startIn; i<=endIn; i++){
            if(in[i] == pre[startPre]){
                root.left = createBinaryTreeByPreIn(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = createBinaryTreeByPreIn(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
                break;
            }
        }
        return root;
    }

}
