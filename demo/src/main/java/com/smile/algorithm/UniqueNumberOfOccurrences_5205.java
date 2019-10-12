package com.smile.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences_5205 {

    public static void main(String[] args) {
        int[] arr = {345,345,567};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freMap = new HashMap<>();
        Set<Integer> countSet = new HashSet<>();
        for(int num : arr) freMap.put(num, freMap.getOrDefault(num, 0)+1);

        for(int key : freMap.keySet()){
            int frep = freMap.get(key);
            if(countSet.add(frep) == false) return false;
        }
        return true;
    }
}
