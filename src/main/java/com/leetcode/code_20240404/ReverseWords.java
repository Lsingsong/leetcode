package com.leetcode.code_20240404;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        List<String> list = Arrays.stream(s.trim().split(" "))
                .filter(k->null != k && !k.isEmpty()).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        list.forEach(k->{
            StringBuilder sb = new StringBuilder(k);
            result.append(sb.reverse().toString()).append(" ");
        });
        return result.reverse().substring(1);
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
