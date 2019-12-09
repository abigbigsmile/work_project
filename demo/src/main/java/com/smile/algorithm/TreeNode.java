package com.smile.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode createBinaryTree(Integer[] nums){
        List<TreeNode> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=null) list.add(new TreeNode(nums[i]));
            else list.add(null);
        }
        for(int i=0; i<list.size()/2-1; i++){
            //左孩子
            list.get(i).left = list.get(2*i+1);
            //右孩子
            list.get(i).right = list.get(2*i+2);
        }
        int lastParent = list.size()/2-1;
        list.get(lastParent).left = list.get(2*lastParent+1);
        if(list.size()%2==0) list.get(lastParent).right = list.get(2*lastParent+2);
        return list.get(0);
    }


    public static TreeNode createBinaryTree(Integer[] arr, int pos){
        if(pos >= arr.length) return null;
        TreeNode root = null;
        if(arr[pos] != null){
            root = new TreeNode(Integer.valueOf(arr[pos]));
            root.left = createBinaryTree(arr, 2*pos+1);
            root.right = createBinaryTree(arr, 2*pos+2);
        }
        return root;
    }
}
