package com.neetcode.dsa.arraysandhashing;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
       // System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }

        public int longestConsecutive(int[] nums) {
            Set<Integer> setIn = new TreeSet<>();
            for(Integer in : nums) setIn.add(in);

            PriorityQueue<Integer> queue= new PriorityQueue<>(Comparator.reverseOrder());
            Integer prev = null;
            int count = 0;
            for( Integer value : setIn){
                if(prev == null){
                    count++;
                }
                else{
                    if(value - prev == 1){
                        count++;
                    }
                    else{
                        queue.add(count);
                        count = 1;
                    }
                }
                prev = value;
            }
            queue.add(count);
            return  queue.isEmpty() ? 0 : queue.poll();
        }

    public int longestConsecutiveV2(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int ans = 1;
        for (int num : nums) set.add(num);
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }
}


