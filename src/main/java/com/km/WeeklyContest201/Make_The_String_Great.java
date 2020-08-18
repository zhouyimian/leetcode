package com.km.WeeklyContest201;

public class Make_The_String_Great {
    public String makeGood(String s) {
        int index = 0;
        StringBuilder ans = new StringBuilder(s);
        while (index+1<ans.length()){
            if(Math.abs(ans.charAt(index)-ans.charAt(index+1))==32){
                ans.deleteCharAt(index);
                ans.deleteCharAt(index);
                index = index==0?0:index-1;
            }else{
                index++;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Make_The_String_Great test = new Make_The_String_Great();
        System.out.println(test.makeGood("abBAcC"));
    }
}
