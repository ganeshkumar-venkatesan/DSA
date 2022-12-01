package com.neetcode.dsa.twopointers;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        //System.out.println(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 8, 100, 2, 100, 4, 8, 3, 7}));
    }


    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        while (leftIndex <= rightIndex) {
            int data = Math.min(height[leftIndex], height[rightIndex]);
            data = data * (rightIndex - leftIndex);
            if (data > max) {
                max = data;
            }
            if (height[leftIndex] > height[rightIndex]) rightIndex--;
            else if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }
        return max;
    }
}
