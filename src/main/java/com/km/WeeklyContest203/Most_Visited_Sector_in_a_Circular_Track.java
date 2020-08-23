package com.km.WeeklyContest203;

import java.util.*;

public class Most_Visited_Sector_in_a_Circular_Track {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result = new ArrayList<>();
        int maxCount = 0;
        Map<Integer,Integer> counter = new HashMap<>();
        if(rounds[0]>rounds[1]){
            for(int j = rounds[0];j<=n;j++){
                counter.put(j,counter.getOrDefault(j,0)+1);
                maxCount = Math.max(maxCount,counter.get(j));
            }
            for(int j = 1;j<=rounds[1];j++){
                counter.put(j,counter.getOrDefault(j,0)+1);
                maxCount = Math.max(maxCount,counter.get(j));
            }
        }else{
            for(int j = rounds[0];j<=rounds[1];j++){
                counter.put(j,counter.getOrDefault(j,0)+1);
                maxCount = Math.max(maxCount,counter.get(j));
            }
        }
        for(int i = 1;i+1<rounds.length;i++){
            if(rounds[i]>rounds[i+1]){
                for(int j = rounds[i]+1;j<=n;j++){
                    counter.put(j,counter.getOrDefault(j,0)+1);
                    maxCount = Math.max(maxCount,counter.get(j));
                }
                for(int j = 1;j<=rounds[i+1];j++){
                    counter.put(j,counter.getOrDefault(j,0)+1);
                    maxCount = Math.max(maxCount,counter.get(j));
                }
            }else{
                for(int j = rounds[i]+1;j<=rounds[i+1];j++){
                    counter.put(j,counter.getOrDefault(j,0)+1);
                    maxCount = Math.max(maxCount,counter.get(j));
                }
            }
        }
        for(Map.Entry<Integer,Integer> entry:counter.entrySet()){
            if(entry.getValue()==maxCount)
                result.add(entry.getKey());
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Most_Visited_Sector_in_a_Circular_Track test = new Most_Visited_Sector_in_a_Circular_Track();
        int[] nums = {3,2};
        System.out.println(test.mostVisited(5,nums));
    }
}
