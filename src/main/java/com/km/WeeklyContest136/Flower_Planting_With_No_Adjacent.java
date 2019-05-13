package com.km.WeeklyContest136;

import java.util.*;

public class Flower_Planting_With_No_Adjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        for(int i = 0;i<N;i++)
            map.put(i,new ArrayList<>());
        for(int i = 0;i<paths.length;i++){
            int from = paths[i][0]-1;
            int to = paths[i][1]-1;
            List<Integer> list = map.get(from);
            list.add(to);
            map.put(from,list);
            list = map.get(to);
            list.add(from);
            map.put(to,list);
        }
        int[] colors = new int[N];
        for(int i = 0;i<N;i++){
            List<Integer> list = map.get(i);
            if(list.size()==0)
                colors[i] = 1;
            else{
                Collections.sort(list);
                int first = 1;
                int second = 1;
                int third = 1;
                int fouth = 1;
                for(int num:list){
                    if(colors [num]==1)
                        first--;
                    else if(colors [num]==2)
                        second--;
                    else if(colors [num]==3)
                        third--;
                    else if(colors [num]==4)
                        fouth--;
                }
                colors[i] = first==1?1:second==1?2:third==1?3:4;
            }
        }
        return colors;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{2,3},{3,1}};
        Flower_Planting_With_No_Adjacent test = new Flower_Planting_With_No_Adjacent();
        int[] ans = test.gardenNoAdj(3,nums);
        for(int num:ans)
            System.out.println(num);
    }
}
