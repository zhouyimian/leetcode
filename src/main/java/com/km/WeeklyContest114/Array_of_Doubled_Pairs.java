package com.km.WeeklyContest114;

import java.util.*;

public class Array_of_Doubled_Pairs {
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        List<Integer> positivearr=new ArrayList<>();
        List<Integer> negativearr=new ArrayList<>();
        Map<Integer,Integer> positiveMap=new HashMap<>();
        Map<Integer,Integer> negativeMap=new HashMap<>();
        for(int num:A){
            if(num>0) {
                positivearr.add(num);
                positiveMap.put(num,positiveMap.getOrDefault(num,0)+1);
            }
            else if(num<0) {
                negativearr.add(-num);
                negativeMap.put(-num, negativeMap.getOrDefault(-num, 0) + 1);
            }
        }
        if(positivearr.size()%2!=0||negativearr.size()%2!=0)
            return false;
        Collections.sort(positivearr);
        Collections.sort(negativearr);
        if(deal(positivearr,positiveMap)== false)
            return false;
        if(deal(negativearr,negativeMap)== false)
            return false;
        return true;
    }

    private boolean deal(List<Integer> list, Map<Integer, Integer> map) {
        for(int i=list.size()-1;i>=0;i--){
            if(map.get(list.get(i))==0)
                continue;
            if(list.get(i)%2!=0)
                return false;
            Integer count=map.get(list.get(i)/2);
            if(count==null||count==0)
                return false;
            else{
                map.put(list.get(i),map.get(list.get(i))-1);
                map.put(list.get(i)/2,map.get(list.get(i)/2)-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={3,1,3,6};
        Array_of_Doubled_Pairs test=new Array_of_Doubled_Pairs();
        System.out.println(test.canReorderDoubled(nums));
    }


}
