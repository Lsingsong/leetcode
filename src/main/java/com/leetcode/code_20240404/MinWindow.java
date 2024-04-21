package com.leetcode.code_20240404;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length() || s.isEmpty()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        while (i<t.length()) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            i++;
        }
        int l = t.length();
        while (l <= s.length()) {
            for (int j=0; j<s.length()-l+1;j++) {
                String substring = s.substring(j, j + l);
                if (is(substring, map)) {
                    return substring;
                }
            }
            l++;
        }
        return "";
    }

    public static boolean is(String s, Map<Character, Integer> map) {
        Map<Character, Integer> map1 = new HashMap<>(map);
        for (int i=0; i<s.length(); i++) {
//            if (map1.containsKey(s.charAt(i))) {
//                int num = map1.get(s.charAt(i))-1;
//                if (num == 0) {
//                    map1.remove(s.charAt(i));
//                } else {
//                    map1.put(s.charAt(i), num);
//                }
//            }
            int num = map1.getOrDefault(s.charAt(i), 0)-1;
            if (num<0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
}
