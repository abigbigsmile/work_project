package com.smile.WrittenExamination;

import java.util.Scanner;

public class TraversingGraph {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] t = new int[100005];
        int x, y;
        for (int i = 0; i < N - 1; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            t[y] = t[x] + 1;
        }
        int depth = 0;
        for (int i = 1; i <= N; i++) {
            depth = t[i] > depth ? t[i] : depth;
        }
        System.out.println(2 * N - 2 - depth);
    }

}
