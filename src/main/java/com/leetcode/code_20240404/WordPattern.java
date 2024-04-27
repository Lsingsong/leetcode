package com.leetcode.code_20240404;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> s2t = new HashMap<Character, String>();
        Map<String, Character> t2s = new HashMap<String, Character>();
        int len = pattern.length();
        String[] st = s.split(" ");
        if (len != st.length) {
            return false;
        }
        for (int i = 0; i < len; ++i) {
            char x = pattern.charAt(i);
            if ((s2t.containsKey(x) && !Objects.equals(s2t.get(x), st[i])) || (t2s.containsKey(st[i]) && t2s.get(st[i]) != x)) {
                return false;
            }
            s2t.put(x, st[i]);
            t2s.put(st[i], x);
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(wordPattern("aaa", "aa aa aa aa"));
    }
}
