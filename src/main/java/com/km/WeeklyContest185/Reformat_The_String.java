package com.km.WeeklyContest185;

import java.util.ArrayList;
import java.util.List;

public class Reformat_The_String {
    public String reformat(String s) {
        List<Character> digit = new ArrayList<>();
        List<Character> lowercase = new ArrayList<>();
        for(Character c:s.toCharArray()){
            if(c>='a'&&c<='z')
                lowercase.add(c);
            else
                digit.add(c);
        }
        if(Math.abs(digit.size()-lowercase.size())>=2)
            return "";
        StringBuilder ans = new StringBuilder();
        boolean flag = digit.size()>lowercase.size();
        int indexA = 0;
        int indexB = 0;
        for(int i = 0;i<s.length();i++){
            if(flag){
                ans.append(digit.get(indexA++));
                flag = false;
            }else{
                ans.append(lowercase.get(indexB++));
                flag = true;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Reformat_The_String test = new Reformat_The_String();
        System.out.println(test.reformat("covid2019"));
    }
}
