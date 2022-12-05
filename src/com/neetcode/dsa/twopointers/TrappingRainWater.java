package com.neetcode.dsa.twopointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        //System.out.println(trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trappingRainWater.trap(new int[]{4,2,0,3,2,5}));
    }

    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] =0;
        rightMax[height.length-1] =0;

        for(int i =1 ; i< height.length-1; i++){
            int value = Math.max(height[i-1], leftMax[i-1] );
            leftMax[i] = value;
        }
        // leftMax will contain all the max value to the left on its index
        //{4,2,0,3,2,5} for this [0,4,4,4,4,0]

        for(int j = height.length-2; j>0; j--){
            int value = Math.max(height[j+1], rightMax[j+1]);
            rightMax[j] = value;
        }
        //rightMax will contain all the max value to the right on its index right-> left
        //{4,2,0,3,2,5} for this [0,5,5,5,5,0]

        int water = 0;
        for(int k =0; k<height.length-1; k++){
            int value = Math.min(leftMax[k],rightMax[k]);
            value = Math.max(value - height[k],0);
            water += value;
        }

        return water;

    }


    public int trapV2(int[] height){
        if (height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }

        return res;
    }
}
