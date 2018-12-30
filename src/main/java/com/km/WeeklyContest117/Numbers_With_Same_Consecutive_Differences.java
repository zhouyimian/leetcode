package com.km.WeeklyContest117;

import java.util.*;

public class Numbers_With_Same_Consecutive_Differences {
    public int[] numsSameConsecDiff(int N, int K) {
        int[] ans=new int[10];
        Map<String,List<StringBuilder>> map=new HashMap<>();
        for(int i=0;i<=9;i++) {
            List<StringBuilder> list=new ArrayList<>();
            list.add(new StringBuilder(i+""));
            map.put("1" + "+" + i, list);
        }
        for(int i=2;i<=N;i++){
            for(int j=0;j<=9;j++){
                if(j+K<=9){
                    List<StringBuilder> list=new ArrayList<>();
                    List<StringBuilder> temp=map.getOrDefault((i-1)+"+"+(j+K),new ArrayList<>());
                    for(StringBuilder sb:temp){
                        StringBuilder tempsb=new StringBuilder(sb);
                        tempsb.append(j);
                        list.add(tempsb);
                    }
                    map.put(i+"+"+j,list);
                }
                if(j-K>=0){
                    List<StringBuilder> list=map.getOrDefault(i+"+"+j,new ArrayList<>());
                    List<StringBuilder> temp=map.get((i-1)+"+"+(j-K));
                    for(StringBuilder sb:temp){
                        StringBuilder tempsb=new StringBuilder(sb);
                        tempsb.append(j);
                        list.add(tempsb);
                    }
                    map.put(i+"+"+j,list);
                }
            }
        }
        List<StringBuilder> temp=new ArrayList<>();
        Set<String > res=new HashSet<>();
        StringBuilder filter=new StringBuilder();
        if(N>1) {
            for (int i = 0; i < N; i++)
                filter.append("0");
            for (int i = 0; i <= 9; i++)
                temp.addAll(map.getOrDefault(N + "+" + i,new ArrayList<>()));
            for (StringBuilder sb : temp) {
                if (!filter.equals(sb.toString()) && !(sb.charAt(0) == '0'))
                    res.add(sb.toString());
            }
        }
        else{
            for (int i = 0; i <= 9; i++)
                temp.addAll(map.get(N + "+" + i));
            for (StringBuilder sb : temp)
                    res.add(sb.toString());
        }
        ans=new int[res.size()];
        int index=0;
        for(String s:res)
            ans[index++] = Integer.parseInt(s);
        return ans;
    }

    public static void main(String[] args) {
        Numbers_With_Same_Consecutive_Differences test=new Numbers_With_Same_Consecutive_Differences();
        for(int num:test.numsSameConsecDiff(2,0))
            System.out.println(num);
    }
}
