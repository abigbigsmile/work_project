package com.smile.nowcoder.second;

import com.smile.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/21 13:43
 * @ModifiedBy smile
 */
public class SixtyTwo {


    public static void main(String[] args) {
        String[] strs = "#,".split(",");
        System.out.println();
    }

    private int index = -1;

    String Serialize(TreeNode root) {
        if(root==null) return "#,";
        StringBuilder sb = new StringBuilder();
        String left = Serialize(root.left);
        String right = Serialize(root.right);

        sb.append(root.val);
        sb.append(left);
        sb.append(right);
        sb.append("!");
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if(str==null) return null;
        String[] strs = str.split(",");
        index++;
        if(strs[index].equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(strs[index]));
        node.left = Deserialize(str);
        node.right = Deserialize(str);
        return node;
    }

}
