package com.neetcode.dsa.arraysandhashing;

import java.util.*;

public class EncodeAndDecodeString {
    public static void main(String[] args) {
        EncodeAndDecodeString encodeAndDecodeString = new EncodeAndDecodeString();
        String encoded = encodeAndDecodeString.encode(Arrays.asList("lint", "code", ":", "love", "you"));
        System.out.println(encodeAndDecodeString.decode(encoded));
    }

    public String encode(List<String> strs) {
        String output = "";
        for (int j = 0; j < strs.size(); j++) {
            output += strs.get(j);
            if (j != strs.size() - 1) {
                output += "&";
            }
        }
        return output;

        /* use below code if the input may contain any special character
        String [] encodingHelper = {"@","#","$","%","&",";",":"};
        int i=0;
        boolean findFlag = false;
        do{
            findFlag =false;
            for (String data : strs){
                if(data.contains(encodingHelper[i])){
                    i++;
                    findFlag = true;
                    break;
                }
            }
        }while (findFlag);
         */
    }

    public List<String> decode(String str) {
        //if there isn't gonna be any special character in input
        //String[] strArray = str.replaceAll("\\W+"," ").split(" ");

        String specialCharacterString = str.replaceAll("[a-zA-Z]", "");
        Map<Character, Integer> specialCharacterMap = new HashMap<>();
        for (char a : specialCharacterString.toCharArray()) {
            specialCharacterMap.put(a, specialCharacterMap.getOrDefault(a, 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> keyMapQueue = new PriorityQueue<>((a, b) -> a.getValue() > b.getValue() ? -1 : 1);
        keyMapQueue.addAll(specialCharacterMap.entrySet());
        Character s = keyMapQueue.poll().getKey();
        String[] strArray = str.replaceAll(s.toString(), " ").split(" ");
        return new ArrayList<>(Arrays.asList(strArray));
    }
}
