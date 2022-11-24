package com.neetcode.dsa.arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        groupAnagram.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> outData = new ArrayList<>();
        List<String> data = new ArrayList<>();
        for (String a: strs
             ) {
            Arrays.sort(a.toCharArray());
            data.add(new String(a));
        }
        System.out.println(data);
        return null;
    }
}
