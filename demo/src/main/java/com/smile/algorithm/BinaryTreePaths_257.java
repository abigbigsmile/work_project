package com.smile.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

public class BinaryTreePaths_257 {

    public static void main(String[] args) {

        String[] arr = {"1", "2", "3","4", "5","6", "7", "8","9"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        binaryTreePaths(root);
        binaryTreePaths_x(root);
        System.out.println();
    }


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(root, res, sb);
        return res;

    }

    private static void helper(TreeNode root, List<String> res, StringBuilder sb){
        if(root == null) return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }else{
            sb.append("->");
            helper(root.left, res, sb);
            helper(root.right, res, sb);
        }
        sb.setLength(len);
    }

    private static List<String> binaryTreePaths_x(TreeNode root) {

        List<String> paths = new LinkedList<>();
        if(root == null) return paths;
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }
        for (String path : binaryTreePaths_x(root.left)) {
            paths.add(root.val + "->" + path);
        }
        for (String path : binaryTreePaths_x(root.right)) {
            paths.add(root.val + "->" + path);
        }
        return paths;

    }



}
