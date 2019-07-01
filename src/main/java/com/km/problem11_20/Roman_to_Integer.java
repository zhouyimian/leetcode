package com.km.problem11_20;

public class Roman_to_Integer {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            if(i!=s.length()-1){
                int value1 = getValue(s.charAt(i));
                int value2 = getValue(s.charAt(i+1));
                if(value1>=value2)
                    ans+=value1;
                else{
                    ans+=(value2-value1);
                    i++;
                }
            }
            else{
                ans+=getValue(s.charAt(i));
            }
        }
        return ans;
    }
    public int getValue(char c){
        if(c=='I')
            return 1;
        else if(c=='V')
            return 5;
        else if(c=='X')
            return 10;
        else if(c=='L')
            return 50;
        else if(c=='C')
            return 100;
        else if(c=='D')
            return 500;
        else
            return 1000;
    }
}
