package com.smile.nowcoder.First;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrintMinNumber {

    public static void main(String[] args) {
        int[] nums = {3, 3, 321};
        String res = PrintMinNumber(nums);
        System.out.println(res);
    }


    public static String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0) return "";
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length()){
                    return o1.length()-o2.length();
                }else{
                    for(int i=0; i<o1.length(); i++){
                        int i1 = o1.charAt(i)-'0';
                        int i2 = o2.charAt(i)-'0';
                        if(i1 != i2) return i1-i2;
                    }
                }
                return 0;
            }
        });
        Arrays.sort(numbers);
        helper(numbers, priorityQueue, new StringBuilder(), 0, new boolean[numbers.length]);
        return priorityQueue.peek();
    }

    public static void helper(int[] numbers, PriorityQueue<String> queue, StringBuilder sb, int count, boolean[] visited){
        if(count==numbers.length){
            queue.offer(sb.toString());
            return;
        }
        for(int i=0; i<numbers.length; i++){
            if(i>0 && !visited[i-1] && numbers[i-1]==numbers[i]) continue;
            if(!visited[i]){
                visited[i] = true;
                sb.append(numbers[i]);
                helper(numbers, queue, sb, count+1, visited);
                sb.delete(sb.length()-String.valueOf(numbers[i]).length(), sb.length());
                visited[i] = false;
            }
        }
    }

    public static String PrintMinNumber_x(int [] numbers) {
        if(numbers==null || numbers.length==0) return "";
        String[] strs = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) strs[i] = String.valueOf(numbers[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String str : strs) sb.append(str);
        return sb.toString();
    }
}
