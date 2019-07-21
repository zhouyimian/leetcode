package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for(int i = 1;i<=numRows;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 1;j<=i;j++){
                if(j==1||j==i){
                    list.add(1);
                }else{
                    list.add(ans.get(i-2).get(j-2)+ans.get(i-2).get(j-1));
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Pascals_Triangle test = new Pascals_Triangle();
        System.out.println(test.generate(5));
    }
}
