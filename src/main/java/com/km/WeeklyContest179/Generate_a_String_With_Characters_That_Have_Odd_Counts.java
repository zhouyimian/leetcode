package com.km.WeeklyContest179;

public class Generate_a_String_With_Characters_That_Have_Odd_Counts {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if(n%2==0){
            sb.append("a");
            for(int i = 1;i<n;i++)
                sb.append("b");
        }else {
            for(int i = 1;i<=n;i++)
                sb.append("a");
        }
        return sb.toString();
    }
}
