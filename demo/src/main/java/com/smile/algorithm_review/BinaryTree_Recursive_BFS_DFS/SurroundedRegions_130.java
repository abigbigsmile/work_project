package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

public class SurroundedRegions_130 {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X',}
        };
        solve(board);
        System.out.println();

    }

    public static void solve(char[][] board) {
        for(int j=0; j<board[0].length; j++){
            if(board[0][j]=='O') mark(board, 0, j);
            if(board[board.length-1][j]=='O') mark(board, board.length-1, j);
        }

        for(int i=0; i<board.length; i++){
            if(board[i][0]=='O') mark(board, i, 0);
            if(board[i][board[0].length-1]=='O') mark(board, i, board[0].length-1);
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '*') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }

    private static void mark(char[][] board, int i, int j) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O') return;
        board[i][j] = '*';
        mark(board, i+1, j);
        mark(board, i, j+1);
        mark(board, i, j-1);
        mark(board, i-1, j);
    }


}
