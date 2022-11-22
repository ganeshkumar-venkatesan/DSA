package com.neetcode.dsa.arraysandhashing;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        // 1. Contains Duplicate
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,4,5,6,7}));
    }
    public boolean containsDuplicate(int[] nums) {

        //using map
        Map<Integer, Integer> num = new HashMap<>();
        for(int a: nums){
            if(num.get(a) == null){
                num.put(a, 1);
            }else{
                return true;
            }
        }
        return false;

        /* using set
        Set<Integer> num = new HashSet<>();
        for(int a : nums){
            num.add(a);
        }
        if(num.size() == nums.length){
            return false;
        }
        return true;
         */

        /* using traditional stream
        long count = Arrays.stream(nums).distinct().count();
        if(count == nums.length){
            return false;
        }
        return true;
         */
    }
}
