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
        res.addAll(map.values());
        return res;
    }


    /*
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        List<String> sortedStringList = new ArrayList<>();
        for (int i=0; i<strs.length; i++){
            char[] d = strs[i].toCharArray();
            Arrays.sort(d);
            sortedStringList.add(new String(d));
        }
        System.out.println(sortedStringList);

        Set<String> xx = new HashSet<>(sortedStringList);
        System.out.println(xx);

        for (int k =0; k< sortedStringList.size(); k++){

        }
        //Collections.sort(sortedStringList);
        Map<String, List<Integer>> indexes = new LinkedHashMap<>();
        for (int j = 0; j < sortedStringList.size(); j++) {
            if(indexes.get(sortedStringList.get(j)) != null)
            {
                List<Integer> indexList=indexes.get(strs[j]);
                indexList.add(j);
                indexes.put(strs[j],indexList);
            }
            else
            {
                List<Integer> indexList =  new ArrayList<>();
                indexList.add(j);
                indexes.put(strs[j],indexList);
            }
        }
        System.out.println(indexes);
        for(Map.Entry<String, List<Integer>> x : indexes.entrySet()){
            List<String> out = new ArrayList<>();
            for(Integer j: x.getValue()){
                out.add(strs[j]);
            }
            result.add(out);
        }
        System.out.println(result);

        return null;
    }
     */
}
