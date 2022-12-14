package com.neetcode.dsa.slidingwindow;

import java.util.*;

public class LongestSubStringWithoutRepeating {

    public static void main(String[] args) {
        LongestSubStringWithoutRepeating longestSubStringWithoutRepeating = new LongestSubStringWithoutRepeating();
        System.out.println(longestSubStringWithoutRepeating.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
/*
 int left = 0, right = 1;
        PriorityQueue<Integer> queueData = new PriorityQueue<>(Comparator.reverseOrder());
        if (s.isEmpty()) return 0;
        int stringLength = s.toCharArray().length;

        while (right < stringLength) {
            Set<String> setData = new HashSet<>();
            if (s.charAt(left) != s.charAt(right)) {
                setData.add(String.valueOf(s.charAt(left)));
                setData.add(String.valueOf(s.charAt(right)));
                left = right;
                right++;
                if (right == stringLength - 1 &&
                        s.charAt(left) != s.charAt(right) && s.charAt(right) != s.charAt(left - 1)) {
                    queueData.add(setData.size());
                }else{
                    queueData.add(setData.size());
                    break;
                }
                while (s.charAt(left) != s.charAt(right) && s.charAt(right) != s.charAt(left - 1)) {
                    if (!setData.add(String.valueOf(s.charAt(right)))) {
                        queueData.add(setData.size());
                        break;
                    }
                    left = right;
                    if (right + 1 < stringLength) {
                        right++;
                    } else
                        break;
                }
                queueData.add(setData.size());
            } else {
                left = right;
                right++;
            }
            if (right > stringLength - 1) {
                break;
            }
        }

        return queueData.isEmpty() ? 1 : queueData.poll();
 */