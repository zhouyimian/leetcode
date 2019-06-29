package com.km.problem1_10;

public class String_to_Integer_atoi {
    public int myAtoi(String str) {
        long ans = 0;
        int sign = 1;
        if(str==null||str.length()==0||str.trim().length()==0)
            return 0;
        else{
            str = str.trim();
            if(str.charAt(0)=='-'||str.charAt(0)=='+'){
                sign = str.charAt(0)=='-'?-1:1;
                ans = deal(str.substring(1));
            }else if(str.charAt(0)>='0'&&str.charAt(0)<='9'){
                ans = deal(str);
            }else
                return 0;
        }
        if(sign==1){
            if(ans>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int) ans;
        }else{
            if(ans*sign<=Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return (int)(sign*ans);
        }
    }

    private long deal(String str) {
        long ans = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                if(ans>Integer.MAX_VALUE)
                    return ans;
                ans = (ans*10)+str.charAt(i)-'0';
            }else{
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("121");
        StringBuilder sb2 = new StringBuilder(sb);
        sb.reverse();
        System.out.println(sb.toString().equals(sb2.toString()));
    }
}
