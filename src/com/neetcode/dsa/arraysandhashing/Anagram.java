package com.neetcode.dsa.arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        // 2. Is Anagram
        Anagram anagram = new Anagram();
        //anagram.isAnagram("a gentleman","elegant man");
        System.out.println(anagram.isAnagram("anagram", "nagaram"));
    }

    /*
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;

        int[] arr = new int[26];
        //small 'a' starts from 97 so in order to reduce the size of arr were reducing 97 so it can start from 0
        for(int i = 0; i< s.length(); i++){
            arr[s.charAt(i) - 97]++;
            arr[t.charAt(i) - 97]--;
        }
        for(int n : arr){
            if(n != 0)return false;
        }
        return true;
    }*/

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        char[] arrOne = s.toCharArray();
        char[] arrTwo = t.toCharArray();
        Arrays.sort(arrOne);
        Arrays.sort(arrTwo);
        if(Arrays.equals(arrOne,arrTwo))
            return true;
        else
            return false;
    }
    /* brute force
    public void isAnagram(String s, String t) {

        // removing the space's between the words
        s = s.replaceAll("\\s","");
        t = t.replaceAll("\\s","");

        // after trimming checking if the size is equal or not
        if(s.length() != t.length()){
            System.out.println("Its not an anagram");
            return;
        }

        // making into lower case and then to array
        char[] stringOne = s.toLowerCase(Locale.ROOT).toCharArray();
        char[] stringTwo = t.toLowerCase(Locale.ROOT).toCharArray();

        Map<Character,Integer> stringOneMapData = new HashMap<>();
        Map<Character,Integer> stringTwoMapData = new HashMap<>();

        // feeding string data into map
        for (char c: stringOne){
            if(stringOneMapData.get(c) == null){
                stringOneMapData.put( c ,1 );
            }else{
                stringOneMapData.replace(c, stringOneMapData.get(c) + 1 );
            }
        }
        // feeding string data into map
        for (char c: stringTwo){
            if(stringTwoMapData.get(c) == null){
                stringTwoMapData.put( c ,1 );
            }else{
                stringTwoMapData.replace(c, stringTwoMapData.get(c) + 1 );
            }
        }
        boolean result = true;
        // checking whether no of characters same or not
        for (Map.Entry<Character, Integer>  data : stringOneMapData.entrySet()){
            if (data.getValue() == stringTwoMapData.get(data.getKey())){
                continue;
            }else {
                result = false;
                break;
            }
        }
        // displaying the result
        if (result){
            System.out.println("Its an anagram");
        }else
            System.out.println("Its not an anagram");

    }*/

}
