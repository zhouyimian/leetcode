package com.km.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pyramid_Transition_Matrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:allowed){
            List<String> list = map.getOrDefault(s.substring(0,2),new ArrayList<>());
            list.add(s.substring(2));
            map.put(s.substring(0,2),list);
        }
        return helper(bottom,map);
    }

    private boolean helper(String bottom, Map<String, List<String>> map) {
        if(bottom.length()==1)
            return true;
        for(int i = 0;i<bottom.length()-1;i++)
            if(map.get(bottom.substring(i,i+2))==null)
                return false;
        List<String> maybe = new ArrayList<>();
        getList(bottom,0,new StringBuilder(),map,maybe);
        for(String s:maybe){
            if(helper(s,map))
                return true;
        }
        return false;
    }

    private void getList(String bottom,int index,StringBuilder sb , Map<String, List<String>> map, List<String> maybe) {
        if(index==bottom.length()-1){
            maybe.add(sb.toString());
            return;
        }
        for(String s:map.get(bottom.substring(index,index+2))){
            sb.append(s);
            getList(bottom,index+1,sb,map,maybe);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
