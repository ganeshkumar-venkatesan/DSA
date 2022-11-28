package com.neetcode.dsa.arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeString {
    public static void main(String[] args) {
        EncodeAndDecodeString encodeAndDecodeString = new EncodeAndDecodeString();
        String encoded = encodeAndDecodeString.encode(Arrays.asList("lint","code","love","you"));
        System.out.println(encodeAndDecodeString.decode(encoded));
    }

    public String encode(List<String> strs) {
        String output ="";
        for (int j = 0; j < strs.size(); j++) {
            output += strs.get(j);
            if(j != strs.size()-1){
                output += "&";
            }
        }
        return output;

        /* use below code if the input may contain any special character
        String [] encodingHelper = {"^","@","#","$","%","&",";",":"};
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
        String[] strArray = str.replaceAll("\\W+"," ").split(" ");
        return new ArrayList<>(Arrays.asList(strArray));
    }
}
