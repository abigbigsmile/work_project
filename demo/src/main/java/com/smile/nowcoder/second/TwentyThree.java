package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 11:09
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class TwentyThree {

    /**
     * 思路： 后序遍历最后一个数就是根结点的值，因为是二叉搜索树，左子树必小于根结点值，右子树必大于根结点值；
     * 找到左子树和右子树分界，分别判断：是否左子树全部值小于根，是否右子树所有值大于根
     * 最后分别递归左和右子树
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) return false;
        return isBST(sequence, 0, sequence.length-1);
    }


    public boolean isBST(int[] sequence, int left, int right){
        if(left>right) return true;
        int rootValue = sequence[right];
        int less = left;
        //找到左子树和右子树分界线：less
        while(less<right){
            if(sequence[less]>rootValue) break;
            less++;
        }

        int more = less;
        //判断右子树是否都大于根
        while(more<right){
            if(sequence[more]<rootValue) return false;
            more++;
        }

        return isBST(sequence, left, less-1) && isBST(sequence, less, right-1);
    }

}
