package com.neetcode.dsa.arraysandhashing;

import java.util.*;

public class ContainsDuplicate {
    public void containsDuplicate(int[] nums) {
        long count = Arrays.stream(nums).distinct().count();
        if(count == nums.length){
            System.out.println("No duplicates in a given array");
        }else{
            System.out.println("Contains duplicate");
        }
    }
}
