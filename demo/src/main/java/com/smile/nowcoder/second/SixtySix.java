package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/22 1:20
 * @ModifiedBy smile
 */


/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
 */
public class SixtySix {

    public static void main(String[] args) {
        String str = "ABCESFCSADEE";
        System.out.println(hasPath(str.toCharArray(), 3, 4, "ABCCED".toCharArray()));
    }


    /**
     * 回溯
     * 基本思想：
     * 0.根据给定数组，初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
     * 1.根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入judge
     * 2.根据i和j先确定一维数组的位置，因为给定的matrix是一个一维数组
     * 3.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
     * 4.若k，就是待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
     * 5.下面就是本题的精髓，递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
     * 6.走到这一步，说明本次是不成功的，我们要还原一下标志位数组index处的标志位，进入下一轮的判断。
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){

        if(matrix==null || matrix.length==0 || str==null || str.length==0) return false;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(isCur(matrix, rows, cols, str, new boolean[matrix.length], i, j, 0)) return true;
            }
        }
        return false;

    }

    public static boolean isCur(char[] matrix, int rows, int cols, char[] str, boolean[] isVisited, int x, int y, int count){
        if(x<0 || x>=rows || y<0 || y>=cols || count>=str.length ||  matrix[x*cols+y]!=str[count] || isVisited[x*cols+y]) return false;
        if(count==str.length-1) return true;
        isVisited[x*cols+y] = true;
        return isCur(matrix, rows, cols, str, isVisited, x, y-1, count+1) ||
                isCur(matrix, rows, cols, str, isVisited, x-1, y, count+1) ||
                isCur(matrix, rows, cols, str, isVisited, x, y+1, count+1) ||
                isCur(matrix, rows, cols, str, isVisited, x+1, y, count+1);

    }

}
