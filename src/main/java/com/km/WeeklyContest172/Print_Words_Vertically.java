package com.km.WeeklyContest172;

import java.util.ArrayList;
import java.util.List;

public class Print_Words_Vertically {
    public List<String> printVertically(String text) {
        int maxLength = Integer.MIN_VALUE;
        String[] words = text.split(" ");
        for(String word:words)
            maxLength = Math.max(maxLength,word.length());
        List<StringBuilder> result = new ArrayList<>();
        for(int i = 0;i<maxLength;i++){
            result.add(new StringBuilder(""));
        }
        for(int i = 0;i<maxLength;i++){
            for(int j = 0;j<words.length;j++){
                if(words[j].length()>i){
                    result.get(i).append(words[j].charAt(i));
                }else{
                    result.get(i).append(' ');
                }
            }
        }
        for(StringBuilder sb:result){
            while (sb.length()!=0&&sb.charAt(sb.length()-1)==' '){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        List<String> ans = new ArrayList<>();
        for(StringBuilder sb:result)
            ans.add(sb.toString());
        return ans;
    }

    public static void main(String[] args) {
        Print_Words_Vertically test = new Print_Words_Vertically();
        System.out.println(test.printVertically("TO BE OR NOT TO BE"));
    }
}
