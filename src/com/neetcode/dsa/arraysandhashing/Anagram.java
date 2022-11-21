package com.neetcode.dsa.arraysandhashing;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Anagram {

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

    }
}
