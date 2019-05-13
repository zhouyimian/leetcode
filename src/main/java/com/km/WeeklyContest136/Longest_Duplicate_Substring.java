package com.km.WeeklyContest136;

import java.util.Arrays;
//这题内存不够了，，，没AC掉，，，discuss的大佬代码没能看懂，，
//不过我这个代码是用的后缀数组，基本上是能够满足一般的数据的
//果然hard的要求还是比较高的，，，但是一般面试的话，后缀数组是解决这个经典题目的方法
//可能是后缀数组有什么优化方法？？？
public class Longest_Duplicate_Substring {
    int maxlength = 0;
    public String longestDupSubstring(String S) {
        String ans = "";
        int length = S.length();

        String[] suffix = new String[length];
        for(int i = 0;i<length;i++)
            suffix[i] = S.substring(i);
        Arrays.sort(suffix);
        for(int i = 0;i<length-1;i++){
            int common_len = compare(suffix[i],suffix[i+1]);
            if(common_len>maxlength){
                maxlength = common_len;
                ans = suffix[i].substring(0,maxlength);
            }
        }
        return ans;
    }
    public int compare(String s1,String s2){
        if(s1.length()<=maxlength||s2.length()<=maxlength)
            return 0;
        int i = 0;
        for(i = 0;i<s1.length()&&i<s2.length();i++){
            if(s1.charAt(i)==s2.charAt(i))
                continue;
            else
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        Longest_Duplicate_Substring test = new Longest_Duplicate_Substring();
        System.out.println(test.longestDupSubstring("banana"));
    }
}
