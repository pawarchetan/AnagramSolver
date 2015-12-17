package com.anagrams.solver;

import java.util.Scanner;

public class AnagramSolverUsingCharacterCount {
    public static void main(String[] args) {
        AnagramSolverUsingCharacterCount anagram = new AnagramSolverUsingCharacterCount();
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        if(anagram.isAnagrams(string1, string2)){
            System.out.println("Strings are Anagrams to each other");
        } else {
            System.out.println("Strings are not Anagrams to each other");
        }
    }

    private boolean isAnagrams(String string1, String string2) {
        if(string1.length() != string2.length()){
            return false;
        }
        int[] characterCount = new int[256];
        int chars = 0; //no of unique characters
        char[] string1_array = string1.toCharArray();
        for (char c : string1_array)
        { // count number of each char in String1.
            if (characterCount[c] == 0) ++chars;
            ++characterCount[c];
        }
        int num_completed = 0;
        for (int i = 0; i < string2.length(); ++i)
        {
            int character = string2.charAt(i);
            if (characterCount[character] == 0)
            { // if you find more of char character in string2 than in string1 return false.
                return false;
            }
            --characterCount[character];
            if (characterCount[character] == 0)
            {
                ++num_completed;
                if (num_completed == chars)
                {
                    // it’s a match if string2 has been processed completely
                    return i == string2.length() - 1;
                }
            }
        }
        return false;
    }

}
