package com.smile.algorithm;

import java.util.LinkedList;

public class SurroundedRegions_130 {

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','X','X'},
                {'X','X','O','X'}
        };
        solve(board);
        System.out.println();


    }

    public static void solve(char[][] board) {
        if(board == null || board.length<3 || board[0].length<3) return;
        int xlen = board.length, ylen = board[0].length;
        //标记左右边界为'O'连接的区域
        for(int i=0; i<xlen; i++){
            if(board[i][0] == 'O') mark(board, i, 0);
            if(board[i][ylen-1] == 'O') mark(board, i, ylen-1);
        }

        for(int i=0; i<ylen; i++){
            if(board[0][i] == 'O') mark(board, 0, i);
            if(board[xlen-1][i] == 'O') mark(board, xlen-1, i);
        }

        for(int i=0; i<xlen; i++){
            for(int j=0; j<ylen; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    /*private static void mark(char[][] board, int x, int y) {
        if(x<0 || x>board.length-1 || y<0 || y>board[x].length-1 || board[x][y] != 'O') return;
        board[x][y] = '*';
        mark(board, x, y-1);
        mark(board, x-1, y);
        mark(board, x, y+1);
        mark(board, x+1, y);
    }*/

    //非递归，使用栈
    private static void mark(char[][] board, int x, int y){
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(y);
        stack.push(x);
        while(!stack.isEmpty()){
            x = stack.pop();
            y = stack.pop();
            if(x<0 || x>board.length-1 || y<0 || y>board[x].length-1 || board[x][y]!='O') continue;
            board[x][y] = '*';
            stack.push(y-1);
            stack.push(x);

            stack.push(y);
            stack.push(x-1);

            stack.push(y);
            stack.push(x+1);

            stack.push(y+1);
            stack.push(x);

        }
    }

}
