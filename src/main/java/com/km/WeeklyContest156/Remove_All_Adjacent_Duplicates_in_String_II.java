package com.km.WeeklyContest156;

import java.util.ArrayList;
import java.util.List;

public class Remove_All_Adjacent_Duplicates_in_String_II {
    public String removeDuplicates(String s, int k) {
        class Point{
            char c;
            int count;
            public Point(char c,int count){
                this.c = c;
                this.count = count;
            }
        }
        List<Point> queue = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(queue.size()!=0) {
                if(s.charAt(i)==queue.get(queue.size()-1).c){
                    Point point = queue.get(queue.size() - 1);
                    queue.remove(queue.size()-1);
                    point.count = point.count+1;
                    if(point.count<k){
                        queue.add(point);
                    }
                }else{
                    queue.add(new Point(s.charAt(i),1));
                }
            }else{
                queue.add(new Point(s.charAt(i),1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<queue.size();i++){
            Point point = queue.get(i);
            for(int j = 0;j<point.count;j++)
                sb.append(point.c);
        }
        return sb.toString();
    }
}
