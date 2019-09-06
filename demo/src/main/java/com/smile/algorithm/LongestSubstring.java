package com.smile.algorithm;


import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("longestubstringithoutrepeatingcharacters"));
        System.out.println(lengthOfLongestSubstring_x("longestubstringithoutrepeatingcharacters"));
        System.out.println(lengthOfLongestSubstring_xx("longestubstringithoutrepeatingcharacters"));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring_x(String s) {
        int[] m = new int[256];
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, m[s.charAt(i)]);
            res = Math.max(res, i - left + 1);
            m[s.charAt(i)] = i + 1;
        }
        return res;
    }

    public static int lengthOfLongestSubstring_xx(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<Character>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right));
                right++;
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }

}
