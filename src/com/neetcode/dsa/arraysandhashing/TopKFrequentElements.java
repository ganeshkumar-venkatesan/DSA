package com.neetcode.dsa.arraysandhashing;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(new int[]{6,6,6,6,1,1,1,2,2,3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> groupNum = new HashMap<>();
        for(int a : nums){
            groupNum.put(a,groupNum.getOrDefault(a,0) +1 );
        }
        Queue<Map.Entry<Integer,Integer>> obj = new PriorityQueue<>((a,b)-> a.getValue() > b.getValue() ? -1:1);
        obj.addAll(groupNum.entrySet());

        int[] result = new int[k];
        for (int i =0; i<k; i++){
            result[i] = obj.poll().getKey();
        }
        return result;
        /*
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        System.out.println(map);

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }
        System.out.println(freqMap);
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        int[] arr = new int[k];
        int i=0;
        for (Integer r: res){
            arr[i] = r;
            i++;
        }
        return arr ;
         */
    }
}
