package com.anagrams.solver;

import java.util.Scanner;

public class AnagramSolverUsingQuickSort {

    public static void main(String[] args) {
        AnagramSolverUsingQuickSort anagramSolver = new AnagramSolverUsingQuickSort();
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        if (anagramSolver.isAnagrams(string1, string2)) {
            System.out.println("Strings are Anagrams to each other");
        } else {
            System.out.println("Strings are not Anagrams to each other");
        }

    }

    //Iterative Quick Sort
    private boolean isAnagrams(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] stringCharArray = string1.toCharArray();
        for (int i = 0; i < stringCharArray.length; ++i) {
            int x = pivot(i, stringCharArray);

            int index = -1;
            for (int j = 0; i < string2.length(); ++j) {
                if (string2.charAt(j) == stringCharArray[i]) {
                    index = j;
                    break;
                }
            }

            if (index == -1) {
                // not an anagram
                return false;
            }

            int y = pivot(index, string2.toCharArray());

            if (x != y) {
                return false;
            }
        }
        return true;
    }

    private int pivot(int index, char[] a) {
        int i = 0, j = a.length - 1;
        char t, x = a[index];
        while (i < j) {
            while (i <= a.length - 1 && a[i] <= x) {
                i++;
            }

            while (a[j] > x) {
                j--;
            }

            if (i < j) {
                // swap a[i] and a[j]
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        // swap a[j] and a[index]
        t = a[j];
        a[j] = a[index];
        a[index] = x;
        return j;
    }

}
