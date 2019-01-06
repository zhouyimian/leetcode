package com.km.WeeklyContest118;

import java.util.*;

public class Powerful_Integers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<10000;i++){
            for(int j=0;j<10000;j++){
                int num;
                if((num=(int)(Math.pow(x,i)+Math.pow(y,j)))<=bound){
                    set.add(num);
                    if(y==1||y==0)
                        break;
                }
                else
                    break;
            }
            if(x==1||x==0)
                break;
        }
        List<Integer> ans=new ArrayList<>();
        ans.addAll(set);
        return ans;
    }

    public static void main(String[] args) {
        Powerful_Integers test=new Powerful_Integers();
        for(int num:test.powerfulIntegers(5,3,15))
            System.out.println(num);
    }
}
