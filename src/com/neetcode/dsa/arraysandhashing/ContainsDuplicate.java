package com.neetcode.dsa.arraysandhashing;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        long count = Arrays.stream(nums).distinct().count();
        if(count == nums.length){
            return false;
        }else{
            return true;
        }
    }
}
