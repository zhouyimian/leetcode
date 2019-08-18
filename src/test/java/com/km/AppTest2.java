package com.km;

import java.util.Scanner;

public class AppTest2 {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<words.length;i++){
            char c = words[i].charAt(0);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'
                    ||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
                StringBuilder temp = new StringBuilder(words[i]);
                temp.append("ma");
                for(int j = 0;j<=i;j++)
                    temp.append("a");
                if(i!=words.length-1)
                    temp.append(" ");
                ans.append(temp);
            }else{
                StringBuilder temp = new StringBuilder(words[i].substring(1));
                temp.append(c);
                temp.append("ma");
                for(int j = 0;j<=i;j++)
                    temp.append("a");
                if(i!=words.length-1)
                    temp.append(" ");
                ans.append(temp);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {

        AppTest2 t = new AppTest2();
        System.out.println(t.toGoatLatin("I speak Goat Latin"));
    }
}
