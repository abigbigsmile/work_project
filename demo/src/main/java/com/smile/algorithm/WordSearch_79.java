package com.smile.algorithm;

import java.util.ArrayList;
import java.util.List;

public class WordSearch_79 {

    public static void main(String[] args) {
        /*char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };*/
        char[][] board =
                {
                        {'a'},
                };
        String word = "ab";
        System.out.println(exist(board, word));
        System.out.println(exist_x(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(helper(board, word, dir, isVisited, i, j, 0)) return true;
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, String word, int[][] dir, boolean[][] isVisited, int x, int y, int count){
        board[x][y] ^= 256;
        if(count == word.length()-1) return board[x][y] == word.charAt(count);
        if(board[x][y] == word.charAt(count)){
            isVisited[x][y] = true;
            for(int i=0; i<dir.length; i++){
                int dx = dir[i][0];
                int dy = dir[i][1];
                int curx = x+dx;
                int cury = y+dy;
                if(curx <0 || curx>=board.length || cury<0 || cury>=board[0].length || isVisited[curx][cury]) continue;
                if (helper(board, word, dir, isVisited, curx, cury, count+1)) return true;
            }
            isVisited[x][y] = false;
        }
        return false;
    }

    public static boolean exist_x(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public static boolean backtrack(char[][] board, String word, int x, int y, int index){
        if(index == word.length()) return true;
        if(x<0 || x>=board.length || y<0 || y>board[x].length || word.charAt(index)!=board[x][y]) return false;
        board[x][y] = '*';
        if(
                backtrack(board, word, x, y-1, index+1) ||
                        backtrack(board, word, x-1, y, index+1) ||
                        backtrack(board, word, x+1, y, index+1) ||
                        backtrack(board, word, x, y+1, index+1)
        ){
            return true;
        }
        board[x][y] =word.charAt(index);
        return false;
    }

}
