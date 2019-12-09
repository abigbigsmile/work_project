package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

public class WordSearch_79 {

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }


    public static boolean exist(char[][] board, String word) {
        if(word==null || word.isEmpty()) return false;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if(helper(board, visited, i, j, word, dir, 1)) return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, boolean[][] visited, int x, int y, String word, int[][] dir, int count){
        if(count==word.length()) return true;
        for(int i=0; i<dir.length; i++){
            int cx = x + dir[i][0];
            int cy = y + dir[i][1];
            if(cx<0 || cx>=board.length || cy<0 || cy>=board[0].length || visited[cx][cy]) continue;
            if(board[cx][cy] == word.charAt(count)){
                visited[cx][cy] = true;
                return helper(board, visited, cx, cy, word, dir, count+1);
            }
        }
        return false;
    }
}
