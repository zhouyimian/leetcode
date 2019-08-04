package com.km.WeeklyContest148;

public class Longest_Chunked_Palindrome_Decomposition {
    public int longestDecomposition(String text) {
        for(int i = 1; i<=text.length()/2; i++)
            if(text.substring(0, i).equals(text.substring(text.length()-i, text.length())))
                return 2 + longestDecomposition(text.substring(i, text.length()-i));
        return text.length() == 0 ? 0 : 1;
    }
}
