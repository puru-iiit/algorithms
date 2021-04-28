package com.puru.random;

public class PatternMatching {

    public static void main(String args[]) {

        String infoType1 = System.getProperty("infoType1");

        int j=0;
        for(int i=0;i<args.length;i++){
            if("-infoType".equals(args[i])){
                j=i;break;
            }
        }
        if(j+1> args.length){
            throw new IllegalArgumentException("value for -infoType required to proceed further");
        }
        String infoType = args[j+1];


        String s = "aa";
        String p = "*";
        System.out.println("Is Matched-->" + new PatternMatching().isMatching(s.toCharArray(), p.toCharArray(),s.length(),p.length()));
    }

    public boolean isMatch(String s, String p) {

        if (s == null && p == null) {
            return true;
        }
        Boolean[][] match = new Boolean[s.length() + 1][p.length() + 1];

        return isMatching(s, p, s.length() - 1, p.length() - 1, match);

    }


    boolean isMatching(char txt[], char pat[], int n, int m){
        // empty pattern can only match with empty string.
        // Base Case :
        if (m == 0)
            return (n == 0);
        // step-1 : initialize markers
        int i = 0, j = 0, index_txt = -1, index_pat = -1;
        while (i < n) {
            if (txt[i] == pat[j]) {  // For step - (2, 5)
                i++;
                j++;
            } else if (j < m && pat[j] == '?') {   // For step - (3)
                i++;
                j++;
            } else if (j < m && pat[j] == '*') { // For step - (4)
                index_txt = i;
                index_pat = j;
                j++;
            } else if (index_pat != -1) {  // For step - (5)
                j = index_pat + 1;
                i = index_txt + 1;
                index_txt++;
            }else {  // For step - (6)
                return false;
            }
        }
        // For step - (7)
        while (j < m && pat[j] == '*') {
            j++;
        }
        // Final Check
        if (j == m) {
            return true;
        }
        return false;
    }

    public boolean isMatching(String s, String p, int n, int m, Boolean[][] match) {
        if (n < 0 && m < 0) {
            return true;
        }
        if (m < 0) {
            return false;
        }
        if (n < 0) {
            for (int i = 0; i <= m; i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (match[n][m] == null) {
            if (p.charAt(m) == '*') {
                match[n][m] = isMatching(s, p, n - 1, m, match) || isMatching(s, p, n, m - 1, match);
            } else {
                if (p.charAt(m) != '?' && s.charAt(n) != p.charAt(m)) {
                    match[n][m] = false;
                } else {
                    match[n][m] = isMatching(s, p, n - 1, m - 1, match);
                }
            }

        }
        return match[n][m];
    }
}