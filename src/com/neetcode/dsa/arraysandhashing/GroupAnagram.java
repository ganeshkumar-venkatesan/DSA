package com.neetcode.dsa.arraysandhashing;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        System.out.println(groupAnagram.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] hash = new char[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        SortedMap<Integer, Integer> obj = new TreeMap<>();
        res.addAll(map.values());
        return res;
    }
}
