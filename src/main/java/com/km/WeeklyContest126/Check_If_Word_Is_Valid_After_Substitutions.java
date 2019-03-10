package com.km.WeeklyContest126;

public class Check_If_Word_Is_Valid_After_Substitutions {
    public boolean isValid(String S) {

        int[] counts = new int[3];
        for(int i = 0;i<S.length();i++){
            counts[S.charAt(i)-'a']++;
            if(counts[2]>counts[1]||counts[1]>counts[0]||counts[2]>counts[0])
                return false;
        }
        if(counts[0]==counts[1]&&counts[1]==counts[2])
            return true;
        else
            return false;
    }
}
