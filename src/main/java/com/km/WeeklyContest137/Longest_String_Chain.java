package com.km.WeeklyContest137;

import java.util.*;

public class Longest_String_Chain {
    List<Map<Character,Integer>> counts;
    public int longestStrChain(String[] words) {
        int ans = 0;
        int[] dp = new int[words.length];
        List<String> list = new ArrayList<>();
        for(String s:words)
            list.add(s);
        Collections.sort(list, (o1, o2) -> o1.length()-o2.length());
        int[] length_index = new int[list.get(list.size()-1).length()+1];
        Arrays.fill(length_index,Integer.MAX_VALUE);
        for(int i = 0;i<list.size();i++){
            length_index[list.get(i).length()] = Math.min(i,length_index[list.get(i).length()]);
        }
        Arrays.fill(dp,1);
        deal(list);
        for(int i = 0;i<dp.length;i++){
            if(length_index[list.get(i).length()-1]==Integer.MAX_VALUE)
                continue;
            else{
                for(int j = length_index[list.get(i).length()-1];j<length_index[list.get(i).length()];j++){
                    if(compare(i,j))
                        dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int num:dp)
            ans = Math.max(ans,num);
        return ans;
    }

    private boolean compare(int i, int j) {
        Map<Character,Integer> map1 = counts.get(i);
        Map<Character,Integer> map2 = counts.get(j);
        Iterator<Character> it = map1.keySet().iterator();
        int diff = 0;
        while(it.hasNext()){
            Character key = it.next();
            if(map2.get(key)==null)
                diff+=map1.get(key);
            else
                diff+=Math.abs(map1.get(key)-map2.get(key));
        }
        return diff==1?true:false;
    }

    private List<Map<Character, Integer>> deal(List<String> list) {
        counts = new ArrayList<>();
        for(String s:list){
            Map<Character,Integer> map = new HashMap<>();
            for(int i = 0;i<s.length();i++)
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            counts.add(map);
        }
        return counts;
    }

    public static void main(String[] args) {
        String[] s = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh",
                "gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        Longest_String_Chain test = new Longest_String_Chain();
        System.out.println(test.longestStrChain(s));
    }
}
