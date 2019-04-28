package com.km;

import java.util.*;


public class AppTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<num;i++){
            int color = sc.nextInt();
            map.put(color,map.getOrDefault(color,0)+1);
        }
        for(int i = num;i>=2;i--){
            if(num%i==0&&check(i,map)){
                System.out.println(num/i);
                return;
            }
        }
        System.out.println(0);
    }
    public static boolean check(int num,HashMap<Integer,Integer> map){
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int value = entry.getValue();
            if(value%num!=0)
                return false;
        }
        return true;
    }
}
