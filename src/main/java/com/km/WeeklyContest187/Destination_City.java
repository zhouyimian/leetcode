package com.km.WeeklyContest187;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Destination_City {
    public String destCity(List<List<String>> paths) {
        Set<String> start = new HashSet<>();
        for(List<String> path:paths){
            start.add(path.get(0));
        }
        for(List<String> path:paths){
            if(!start.contains(path.get(1))){
                return path.get(1);
            }
        }
        return "";
    }
}
