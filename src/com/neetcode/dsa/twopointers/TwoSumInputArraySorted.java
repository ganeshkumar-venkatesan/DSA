package com.neetcode.dsa.twopointers;

import java.util.Arrays;

public class TwoSumInputArraySorted {
    public static void main(String[] args) {
        TwoSumInputArraySorted twoSumInputArraySorted = new TwoSumInputArraySorted();
        System.out.println(Arrays.toString(twoSumInputArraySorted.twoSum(new int[]{-1,0},-1)));
    }

    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;
        while (numbers[i]+numbers[j] !=target){
            while (numbers[i]+numbers[j] > target) {
                j--;
            }
            while (numbers[i]+numbers[j]<target){
                i++;
            }
        }
        return new int[]{i+1,j+1};
    }


    public int[] twoSumV2(int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;
        int num_a, num_b;

        while (a_pointer < b_pointer) {
            num_a = numbers[a_pointer];
            num_b = numbers[b_pointer];

            if (num_a + num_b == target) break;

            if (num_a + num_b < target) {
                a_pointer++;
                continue;
            }

            b_pointer--;
        }

        return new int[] { a_pointer + 1, b_pointer + 1 };
    }

}
