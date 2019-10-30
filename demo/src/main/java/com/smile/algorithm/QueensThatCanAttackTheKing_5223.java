package com.smile.algorithm;

import java.util.*;

public class QueensThatCanAttackTheKing_5223 {

    public static void main(String[] args) {
        int[][] queens = new int[][]{{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] king = {3,3};
        //List<List<Integer>> res = queensAttacktheKing(queens, king);
        //List<List<Integer>> res = queensAttacktheKing_x(queens, king);
        List<List<Integer>> res = queensAttacktheKing_xxx(queens, king);
        System.out.println();
    }
    //这个是傻瓜式的暴力解法
    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int[] queen : queens) set.add(queen[0]+","+queen[1]);
        int x = king[0], y = king[1];
        int i = y-1;
        while(i>=0){
            String s = x+","+i;
            if(set.contains(s)){
                list.add(x);
                list.add(i);
                res.add(new ArrayList<>(list));
                list.clear();
                break;
            }
            i--;
        }
        i = y+1;
        while(i<8){
            String s = x+","+i;
            if(set.contains(s)){
                list.add(x);
                list.add(i);
                res.add(new ArrayList<>(list));
                list.clear();
                break;
            }
            i++;
        }
        int k=x-1;
        while(k>=0){
            String s = k+","+y;
            if(set.contains(s)){
                list.add(k);
                list.add(y);
                res.add(new ArrayList<>(list));
                list.clear();
                break;
            }
            k--;
        }
        k=x+1;
        while(k<8){
            String s = k+","+y;
            if(set.contains(s)){
                list.add(k);
                list.add(y);
                res.add(new ArrayList<>(list));
                list.clear();
                break;
            }
            k++;
        }
        i=x-1;k=y-1;
        while(i>=0&&k>=0){
            String s = i+","+k;
            if(set.contains(s)){
                list.add(i);
                list.add(k);
                res.add(new ArrayList<>(list));
                list.clear();
                break;
            }
            i--;k--;
        }
        i=x-1;k=y+1;
        while(i>=0&&k<8){
            String s = i+","+k;
            if(set.contains(s)){
                list.add(i);
                list.add(k);
                res.add(new ArrayList<>(list));
                list.clear();
                break;
            }
            i--;k++;
        }
        i=x+1;k=y-1;
        while(i<8&&k>=0){
            String s = i+","+k;
            if(set.contains(s)){
                list.add(i);
                list.add(k);
                res.add(new ArrayList<>(list));
                list.clear();
                break;
            }
            i++;k--;
        }
        i=x+1;k=y+1;
        while(i<8&&k<8){
            String s = i+","+k;
            if(set.contains(s)){
                list.add(i);
                list.add(k);
                res.add(new ArrayList<>(list));
                list.clear();
                break;
            }
            i++;k++;
        }
        return res;
    }

    //如何表示往八个方向，并且如何标记该方向已经通过
    public static List<List<Integer>> queensAttacktheKing_x(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> resMap = new HashMap<>();
        //这里代表八个方向
        int[][] dir = new int[][]{
                {-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}
        };
        // 这个设定很重要，代表8个方向是否已经找到一个queen了
        boolean[] isVisited = new boolean[8];
        //代表棋盘queen的位置
        boolean[][] board = new boolean[8][8];
        for(int[] queen : queens){
            board[queen[0]][queen[1]] = true;
        }
        int x = king[0], y = king[1];
        int count = 0;
        //外循环：表示移动的步数; 内循环：往八个方向递增指定步数
        for(int i=1; i<8; i++){
            for(int k=0; k<8; k++){
                int m = x + dir[k][0]*i;
                int n = y + dir[k][1]*i;
                if(m>=0 && n>=0 && m<8 && n<8 && board[m][n] && !isVisited[k]){
                    isVisited[k] = true;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(m);
                    temp.add(n);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    //如何思考这个问题,这个有点像深度搜索DFS
    public static List<List<Integer>> queensAttacktheKing_xx(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] board = new boolean[8][8];
        for(int[] queen : queens) board[queen[0]][queen[1]] = true;
        int x=king[0], y=king[1];
        //还可以使用3*3来表示八个方向
        for(int dx=-1; dx<=1; dx++){
            for(int dy=-1; dy<=1; dy++){
                if(dx==0&&dy==0) continue;
                int m=x+dx, n=y+dy;
                while(m>=0 && n>=0 && m<8 && n<8){
                    if(board[m][n]) {
                        res.add(Arrays.asList(m,n));
                        break;
                    }
                    m+=dx;
                    n+=dy;
                }
            }
        }
        return res;
    }

    //广度搜索，一层层扩大；BFS --> 使用Queue实现
    public static List<List<Integer>> queensAttacktheKing_xxx(int[][] queens, int[] king){
        List<List<Integer>> res = new ArrayList<>();
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        Set<Integer> queensP = new HashSet<>();
        for (int[] queen : queens) {
            queensP.add(queen[0]*9+queen[1]);
        }

        int x=king[0], y=king[1];
        LinkedList<int[]> queue = new LinkedList<>();
        for(int[] dir : dirs) queue.offer(new int[]{x, y, dir[0], dir[1]}); //八个方向
        while(!queue.isEmpty()){
            int[] dir = queue.poll();
            int m = dir[0];
            int n =dir[1];
            int dx = dir[2];
            int dy = dir[3];
            if(n<0 || m<0 || m>=8 ||n>=8) continue;
            if(queensP.contains(m*9+n)){
                res.add(Arrays.asList(m,n));
                continue; //这一句至关重要，表示同一方向的不用再放进queue里面了
            }
            queue.offer(new int[]{m+dx, n+dy, dx, dy});
        }
        return res;
    }

}
