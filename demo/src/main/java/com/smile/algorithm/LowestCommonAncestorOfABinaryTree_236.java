package com.smile.algorithm;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree_236 {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3","4", "5","6", "7", "8","9"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        lowestCommonAncestor(root, new TreeNode(5), new TreeNode(8));
        System.out.println();
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> m = new HashMap<TreeNode,TreeNode>();
        // bfs walking tree
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.peek()!=null){
            TreeNode t = queue.poll();
            if(t.left!=null){
                m.put(t.left,t);
                queue.offer(t.left);
            }
            if(t.right!=null){
                m.put(t.right,t);
                queue.offer(t.right);
            }
        }
        // build route
        Set<TreeNode> l = new HashSet<TreeNode>();
        TreeNode pp = p;
        while(pp!=root){
            l.add(pp);
            pp = m.get(pp);
        }
        l.add(root);
        TreeNode qq = q;
        while(!l.contains(qq)){
            qq = m.get(qq);
        }
        return qq;
    }

    public static TreeNode lowestCommonAncestor_x(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> path = new HashMap<>();
        queue.offer(root);
        path.put(root, null);
        while(!path.containsKey(p) || !path.containsKey(q)){
            TreeNode cur = queue.poll();
            if(cur.left!=null){
                queue.offer(cur.left);
                path.put(cur.left, cur);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
                path.put(cur.right, cur);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while(p!=null){
            set.add(p);
            p = path.get(p);
        }
        while(!set.contains(q)){
            q = path.get(q);
        }

        return q;

    }

}
