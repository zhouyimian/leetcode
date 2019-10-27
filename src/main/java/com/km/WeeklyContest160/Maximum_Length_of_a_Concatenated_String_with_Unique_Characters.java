package com.km.WeeklyContest160;

import java.util.*;

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    int ans = 0;
    int[]sum;
    public int maxLength(List<String> arr) {
        sum = new int[arr.size()];
        sum[0] = arr.get(0).length();
        for(int i = 1;i<arr.size();i++){
            sum[i] = arr.get(i).length()+sum[i-1];
        }
        Map<Character, Set<Integer>> index = new HashMap<>();
        List<String> newList = new ArrayList<>();
        for (String s : arr) {
            if (deal(s)) {
                newList.add(s);
            }
        }
        for (int i = 0;i<newList.size();i++) {
            for (int j = 0; j < newList.get(i).length(); j++) {
                Set<Integer> set = index.getOrDefault(newList.get(i).charAt(j), new HashSet<>());
                set.add(i);
                index.put(newList.get(i).charAt(j),set);
            }
        }
        for(int i = 0;i<newList.size();i++){
            int[] vis = new int[arr.size()];
            String cur = newList.get(i);
            int tempans = cur.length();
            for(int j = 0;j<cur.length();j++){
                Set<Integer> set = index.get(cur.charAt(j));
                for(int num:set)
                    vis[num] = 1;
            }
            dfs(tempans,newList,vis,index);
        }
        return ans;
    }

    private void dfs(int tempans, List<String> list,int[] vis,Map<Character, Set<Integer>> index) {
        if(tempans>ans)
            ans = tempans;
        for(int i = 0;i<list.size();i++){
            if(vis[i]!=1){
                if((tempans+(sum[list.size()-1]-sum[i]))<=ans)
                    return;
                int[] storevis = Arrays.copyOf(vis,vis.length);
                String cur = list.get(i);
                for(int j = 0;j<cur.length();j++){
                    Set<Integer> set = index.get(cur.charAt(j));
                    for(int num:set)
                        vis[num] = 1;
                }
                dfs(tempans+cur.length(),list,vis,index);
                vis = Arrays.copyOf(storevis,vis.length);
            }
        }
    }

    private boolean deal(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                return false;
            set.add(s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Maximum_Length_of_a_Concatenated_String_with_Unique_Characters t = new Maximum_Length_of_a_Concatenated_String_with_Unique_Characters();
        List<String> list = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p");
        System.out.println(t.maxLength(list));
    }
}
