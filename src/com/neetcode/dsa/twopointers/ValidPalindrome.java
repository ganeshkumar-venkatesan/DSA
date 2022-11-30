package com.neetcode.dsa.twopointers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        //System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("aa"));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public boolean isPalindromeV2(String s) {
        s= s.replaceAll("[^a-zA-Z/d]","").toLowerCase();
        if(s=="")return true;
        else if (s.length()==1) {
            return true;
        }else{
            int leftIndex=0;
            int rightIndex=s.length()-1;
            while(s.charAt(leftIndex) == s.charAt(rightIndex)){
                leftIndex++;
                rightIndex--;
                if(leftIndex==rightIndex|| leftIndex-rightIndex == 1)return true;
            }
        }
        return false;
    }

    public boolean isPalindromeV3(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            Character start = s.charAt(i);
            Character end = s.charAt(j);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
