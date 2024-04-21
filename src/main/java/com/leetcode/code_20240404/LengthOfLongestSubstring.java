package com.leetcode.code_20240404;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int j=0;
        int max=0;
        for (int i=0; i<s.length();i++) {
            if (i!=0) {
                set.remove(s.charAt(i-1));
            }
            while (j<s.length()&&!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, j-i);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
