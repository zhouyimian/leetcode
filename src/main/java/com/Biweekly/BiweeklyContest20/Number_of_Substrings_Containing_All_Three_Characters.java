package com.Biweekly.BiweeklyContest20;

import java.util.TreeSet;

public class Number_of_Substrings_Containing_All_Three_Characters {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        TreeSet<Integer> setA = new TreeSet<>();
        TreeSet<Integer> setB = new TreeSet<>();
        TreeSet<Integer> setC = new TreeSet<>();
        int length = s.length();
        for(int i = 0;i<length;i++){
            char c = s.charAt(i);
            if(c=='a')
                setA.add(i);
            else if(c=='b')
                setB.add(i);
            else
                setC.add(i);
        }
        for(int i = 0;i<length-2;i++){
            char c = s.charAt(i);
            int index1 = -1;
            int index2 = -1;
            if(c=='a'){
                index1 = setB.ceiling(i)==null?-1:setB.ceiling(i);
                index2 = setC.ceiling(i)==null?-1:setC.ceiling(i);
            }else if(c=='b'){
                index1 = setA.ceiling(i)==null?-1:setA.ceiling(i);
                index2 = setC.ceiling(i)==null?-1:setC.ceiling(i);
            }else {
                index1 = setA.ceiling(i)==null?-1:setA.ceiling(i);
                index2 = setB.ceiling(i)==null?-1:setB.ceiling(i);
            }
            if(index1==-1||index2==-1)
                break;
            ans+=(length-Math.max(index1,index2));
        }
        return ans;
    }

    public static void main(String[] args) {
        Number_of_Substrings_Containing_All_Three_Characters test = new Number_of_Substrings_Containing_All_Three_Characters();
        System.out.println(test.numberOfSubstrings("ababbbc"));
    }
}
