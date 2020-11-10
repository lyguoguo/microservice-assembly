package com.gly.leetcode;

public class HuiWenXuLie {

    public static void main(String[] args) {
        String s = "aabababb";
        int count = count(s);
        System.out.println("回文序列数："+count);
    }

    private static int count(String s) {
        if ("".equals(s)) return 0;
        if (s.equals(new StringBuilder(s).reverse().toString())) return 1;
        return 2;
    }
}
