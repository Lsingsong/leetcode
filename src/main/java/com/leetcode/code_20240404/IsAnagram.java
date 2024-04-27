package com.leetcode.code_20240404;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> map : map1.entrySet()) {
            if (null == map2.get(map.getKey()) || !Objects.equals(map2.get(map.getKey()), map.getValue())) {
                return false;
            }

        }
        return true;
    }
}
