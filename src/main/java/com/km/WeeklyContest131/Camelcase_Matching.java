package com.km.WeeklyContest131;

import java.util.ArrayList;
import java.util.List;

public class Camelcase_Matching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0;i<queries.length;i++){
            boolean flag = true;
            int index = 0;
            for(int j = 0;j<queries[i].length();j++){
                if(index>=pattern.length()){
                    for(int k = j;k<queries[i].length();k++){
                        if(queries[i].charAt(j)>='A'&&queries[i].charAt(j)<='Z'){
                            flag = false;
                            break;
                        }
                    }
                }else{
                    if(queries[i].charAt(j)==pattern.charAt(index)){
                        index++;
                    }
                    else if(queries[i].charAt(j)>='A'&&queries[i].charAt(j)<='Z'){
                        flag = false;
                        break;
                    }
                }
            }
            if(index<pattern.length())
                ans.add(false);
            else
                ans.add(flag);
        }
        return ans;
    }

    public static void main(String[] args) {
        Camelcase_Matching test = new Camelcase_Matching();
        String[] s = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        for(Boolean ans:test.camelMatch(s,pattern)){
            System.out.println(ans);
        }
    }
}
