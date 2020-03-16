package com.smile.nowcoder.First;

public class VerifySquenceOfBST {

    public static void main(String[] args) {

    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        return helper(sequence, 0, sequence.length-1);
    }
    public static boolean helper(int[] sequence, int left, int right){
        if(left>right) return true;
        int value = sequence[right];
        int smaller = left, bigger = right;
        while(smaller<=sequence.length-1 || bigger>=0){
            if(sequence[smaller]>=value)break;
            if(sequence[bigger]<=value)break;
            smaller++;
            bigger--;
        }
        if(smaller==left || smaller==right){
            return true;
        }else if(smaller>bigger){
            return helper(sequence, left, bigger) && helper(sequence, smaller, right-1);
        }else return false;
    }


    public static boolean VerifySquenceOfBST_x(int [] sequence) {
        return VerifySquenceOfBST(sequence);
    }
    public static boolean helper_x(int[] sequence, int left, int right){
        if(left>=right) return true;
        int up = left;
        int value = sequence[right];
        // 找到第一个大于根结点值的坐标
        while(up<right){
            if(sequence[up]>value) break;
            up++;
        }
        // 如果再次出现升序，则不是平衡搜索树
        int down = up;
        while(down<right){
            if(sequence[down]<value) return false;
            down++;
        }
        return helper_x(sequence, left, up-1) && helper_x(sequence, up, right-1);

    }
}
