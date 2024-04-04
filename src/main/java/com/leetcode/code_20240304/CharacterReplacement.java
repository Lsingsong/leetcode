package com.leetcode.code_20240304;

import java.util.*;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> ch2NumMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        int[] ch = new int[26];
        int start = 0;
        int end = 0;
        int max = 0;
        int result = 0;
        if (s.length()<=k) {
            return s.length();
        } else {
            while (end<s.length()) {
                ch[chars[end] - 'A'] += 1;
                max = Math.max(max, ch[chars[end] - 'A']);
                end ++;
                if (end - start > max + k) {
                    ch[chars[start] - 'A'] -= 1;
                    start++;
                }
                result = Math.max(result, end - start);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }
}
