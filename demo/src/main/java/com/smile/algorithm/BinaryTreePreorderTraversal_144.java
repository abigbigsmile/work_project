package com.smile.algorithm;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class BinaryTreePreorderTraversal_144 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(String[] arr, int pos){
        if(pos >= arr.length) return null;
        TreeNode root = null;
        if(arr[pos] != null){
            root = new TreeNode(Integer.valueOf(arr[pos]));
            root.left = buildTree(arr, 2*pos+1);
            root.right = buildTree(arr, 2*pos+2);
        }
        return root;
    }


    public static void main(String[] args) {

        String[] arr = {"1", "2", "3","4", "5"};
        TreeNode root = buildTree(arr, 0);
        List<Integer> list1 = preorderTraversal(root);
        List<Integer> list2 = inorderTraversal(root);
        List<Integer> list5 = postorderTraversal(root);

        List<Integer> list3 = preorderTraversal_x(root);
        List<Integer> list4 = inorderTraversal_x(root);
        List<Integer> list6 = postorderTraversal_x(root);

        //回顾
        List<Integer> list7 = review(root);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list5);
        System.out.println("=============");
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list6);
        System.out.println("=============");
        System.out.println(list7);
    }

    //前序遍历法的递归版本
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            list.add(root.val);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }
    //中序遍历法的递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }
    //后序遍历法的递归
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            list.addAll(postorderTraversal(root.left));
            list.addAll(postorderTraversal(root.right));
            list.add(root.val);
        }
        return list;
    }

    //前序遍历法迭代版本
    public static List<Integer> preorderTraversal_x(TreeNode root)  {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            if(root!=null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                root = root.right;
            }
            /*if(root != null){
                list.add(root.val);
                stack.push(root.right);
                stack.push(root.left);
            }
            root = stack.pop();*/
        }
        return list;
    }
    //中序遍历法迭代版本
    public static List<Integer> inorderTraversal_x(TreeNode root){
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
    //后序遍历迭代法
    public static List<Integer> postorderTraversal_x(TreeNode root){
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return list;
    }

    public static List<Integer> review(TreeNode root){
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                list.push(root.val);
                stack.push(root.left);
                stack.push(root.right);
            }
            root = stack.pop();
        }
        return list;
    }






}
