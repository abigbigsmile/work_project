package com.smile.nowcoder.First;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        System.out.println(FirstNotRepeatingChar(str));
        System.out.println(FirstNotRepeatingChar_x(str));
    }

    public static int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for(char c : str.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry : hashMap.entrySet()){
            if(entry.getValue()==1) return str.indexOf(entry.getKey());
        }
        return -1;
    }

    // 'A'-'z': 65-90; 97-122
    public static int FirstNotRepeatingChar_x(String str) {
        int[] pos = new int[58];
        for(char c : str.toCharArray()) pos[c-'A']++;
        for(char c : str.toCharArray()) if(pos[c-'A']==1) return str.indexOf(c);
        return -1;
    }

}
