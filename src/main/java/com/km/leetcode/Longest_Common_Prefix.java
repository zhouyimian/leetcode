package com.km.leetcode;

public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        int minlength = strs[0].length();
        for(String s:strs)
            minlength = Math.min(minlength,s.length());
        String ans = "";
        boolean flag;
        for(int i = minlength ;i>=0;i--){
            flag = true;
            for(int j = 0;j<strs.length;j++){
                if(!strs[j].substring(0,i).equals(strs[0].substring(0,i))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans = strs[0].substring(0,i);
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(0,3));
    }
}
