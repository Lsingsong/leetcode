package com.leetcode.code_20240404;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<=j){
            char ci = s.toLowerCase().charAt(i);
            char cj = s.toLowerCase().charAt(j);
            if (!Character.isLetterOrDigit(ci)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(cj) ) {
                j--;
                continue;
            }
            if (ci == cj) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(" 0p "));
    }
}
