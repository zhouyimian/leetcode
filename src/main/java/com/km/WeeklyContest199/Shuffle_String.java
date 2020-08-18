package com.km.WeeklyContest199;

public class Shuffle_String {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder("");
        for(int num :indices){
            sb.append(s.charAt(num));
        }
        return sb.toString();
    }
}
