package com.smile.WrittenExamination;

import java.util.PriorityQueue;

public class DongGuanYinHang {

    public static void main(String[] args) {
        printOrdered(2, 1, 5);
        printOrdered_x(2, 1, 5);
    }

    public static void printOrdered(int x, int y, int z){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(x);
        queue.offer(y);
        queue.offer(z);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static void printOrdered_x(int a, int b, int c){
        if(a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if(a < c) {
            int t = a;
            a = c;
            c = t;
        }
        if(b < c) {
            int t = b;
            b = c;
            c = t;
        }
        System.out.println(a + " " + b + " " + c);
    }


}
