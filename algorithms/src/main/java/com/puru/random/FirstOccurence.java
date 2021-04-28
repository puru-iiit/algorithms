package com.puru.random;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

class GFG {
    public static void main(String args[]) throws FileNotFoundException {
        char[] str = "this is a test string".toCharArray();
        char[] pat = "tist".toCharArray();
        System.out.println("Smallest window: " + findSubString(str, pat));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(""), 1000);
    }

    public static String findSubString(char[] str, char[] pat) {
        int len1 = str.length;
        int len2 = pat.length;
        // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }
        int hashPat[] = new int[256];
        int hashStr[] = new int[256];

        // store occurrence ofs characters of pattern
        for (int i = 0; i < len2; i++)
            hashPat[pat[i]]++;

        int start = 0, startIndex = -1, minLen = Integer.MAX_VALUE;
        // start traversing the string
        int count = 0; // count of characters
        for (int j = 0; j < len1; j++) {
            // count occurrence of characters of string
            hashStr[str[j]]++;
            // If string's char matches with pattern's char
            // then increment count
            if (hashPat[str[j]] != 0 &&
                    hashStr[str[j]] <= hashPat[str[j]])
                count++;

            // if all the characters are matched
            if (count == len2) {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while (hashStr[str[start]] > hashPat[str[start]]
                        || hashPat[str[start]] == 0) {
                    if (hashStr[str[start]] > hashPat[str[start]])
                        hashStr[str[start]]--;
                    start++;
                }
                // update window size
                int len_window = j - start + 1;
                if (minLen > len_window) {
                    minLen = len_window;
                    startIndex = start;
                }
            }
        }
        // If no window found
        if (startIndex == -1) {
            System.out.println("No such window exists");
            return "";
        }
        // Return substring starting from startIndex and length minLen
        return new String(str, startIndex, startIndex + minLen);
    }
}