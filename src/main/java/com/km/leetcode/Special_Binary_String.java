package com.km.leetcode;

import java.util.*;

public class Special_Binary_String {
    public String makeLargestSpecial(String S) {
        List<String> list=new ArrayList<>();
        int count=0;
        int i=0;
        for(int j=0;j<S.length();j++){
            if(S.charAt(j)=='1') count++;
            else count--;
            if(count==0){
                list.add("1"+makeLargestSpecial(S.substring(i+1,j))+"0");
                i=j+1;
            }
            Collections.sort(list,Collections.reverseOrder());
        }
        return String.join("",list);
    }

    public static void main(String[] args) {
        Special_Binary_String test=new Special_Binary_String();
        System.out.println(test.makeLargestSpecial("11011000"));
    }
}
