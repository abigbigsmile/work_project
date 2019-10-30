package com.smile.algorithm;

public class NumberOfIslands_200 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int[][] dir = {{0,-1}, {-1,0}, {0, 1},{1,0}};
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(!isVisited[i][j] && grid[i][j]=='1'){
                    count += 1;
                    //markIsland(grid, isVisited, i, j);
                    markIsland_x(grid, dir, isVisited, i, j);
                }
            }
        }
        return count;
    }

    private static void markIsland(char[][] grid, boolean[][] isVisited, int x, int y) {
        if(x<0 || x>grid.length-1 || y<0 || y>grid[x].length-1 || isVisited[x][y] || grid[x][y]!='1') return ;
        isVisited[x][y] = true;
        markIsland(grid, isVisited, x, y-1);
        markIsland(grid, isVisited, x-1, y);
        markIsland(grid, isVisited, x+1, y);
        markIsland(grid, isVisited, x, y+1);
        return ;
    }

    private static void markIsland_x(char[][] grid, int[][] dir, boolean[][] isVisited, int x, int y) {
        if(x<0 || x>grid.length-1 || y<0 || y>grid[x].length-1 || isVisited[x][y] || grid[x][y]!='1') return ;
        isVisited[x][y] = true;
        for(int i=0; i<dir.length; i++) markIsland_x(grid, dir, isVisited, x+dir[i][0], y+dir[i][1]);
        return ;
    }


}
