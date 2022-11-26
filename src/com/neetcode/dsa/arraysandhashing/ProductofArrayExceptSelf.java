package com.neetcode.dsa.arraysandhashing;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
        ProductofArrayExceptSelf productofArrayExceptSelf = new ProductofArrayExceptSelf();
        System.out.println(Arrays.toString(productofArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    //1   1   2  6
    //24  12  4  1
    public int[] productExceptSelf(int[] nums) {

        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) leftToRight[i] = 1;
            else if (i == 1) {
                leftToRight[i] = nums[0];
            } else {
                leftToRight[i] = leftToRight[i - 1] * nums[i - 1];
            }
        }
        int a = nums.length - 1;
        for (int i = a; i > -1; i--) {
            if (i == a) rightToLeft[i] = 1;
            else if (i == a - 1) {
                rightToLeft[i] = nums[a];
            } else {
                rightToLeft[i] = rightToLeft[i + 1] * nums[i + 1];
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftToRight[i]* rightToLeft[i];
        }

        return result;
    }
}
