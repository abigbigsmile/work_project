package com.smile.nowcoder.second;

import com.smile.algorithm.TreeNode;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 23:32
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Seventeen {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return false;
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val != root2.val) return false;
        else return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }

}
