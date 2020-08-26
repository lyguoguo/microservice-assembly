package com.gly.leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

public class Solution {
    public static int missingNumber(int[] nums) {
        int s=0;//实际总和
        int l=0;//不缺元素时的总和
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            l+=i;
        }
        l+=nums.length;
        l-=s;
        return l;
    }

    public static void main(String[] args) {
//        int[] i = {3,1,0};
        int[] i = {9,6,4,2,3,5,7,0,1};
//        int[] i = {0};
        System.out.println("result:"+missingNumber(i));
    }
}