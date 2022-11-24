package com.neetcode.dsa.arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,7,11,15}, 26)));
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i =0; i< nums.length; i++){
            int required = target - nums[i];
            if(data.get(required) != null)
                return new int[]{data.get(required),i};
            else
                data.put(nums[i], i );
        }
        return new int[] {0,0};
    }
}
