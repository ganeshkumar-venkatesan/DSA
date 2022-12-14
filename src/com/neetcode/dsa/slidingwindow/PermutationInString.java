package com.neetcode.dsa.slidingwindow;

import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        boolean flag = false;
        int[] data = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            data[s1.charAt(i) - 97] += 1;
        }
        int left = 0, right = s1.length();
        while (right <= s2.length()) {
            int[] d = new int[26];
            for (int i = left; i < right; i++) {
                d[s2.charAt(i) - 97] += 1;
            }

            for(int i =0; i < 26;i++){
                if (data[i] == d[i]) {
                    flag=true;
                }else{
                    flag=false;
                    break;
                }
            }

            if(flag)break;
            left++;
            right++;

        }
        return flag;
    }
}
