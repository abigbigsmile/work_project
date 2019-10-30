package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SudokuSolver_37 {

    public static void main(String[] args) {
        List<Integer>  list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });
    }

    public static void solveSudoku(char[][] board) {
        helper(board);
    }

    public static boolean helper(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] != '.') continue;
                for(char c='0'; c<='9'; c++){
                    if(isValid(board, i, j, c)){
                        board[i][j] = c;
                        if(helper(board)){
                            return true;
                        }else{
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int x, int y, char c) {
        int xblock = (x/3)*3, yblock = (y/3)*3;
        for(int i=0; i<9; i++){
            if(board[x][i] != '.' && board[x][i] == c) return false;
            if(board[i][y] != '.' && board[i][y] == c) return false;
            if(board[xblock + i/3][yblock + i%3] != '.' && board[xblock + i/3][yblock + i%3] == c) return false;
        }
        return true;
    }
}
