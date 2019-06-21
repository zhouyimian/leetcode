package com.km.WeeklyContest141;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Largest_Values_From_Labels {
    class Node{
        int value;
        int label;
        public Node(int value,int label){
            this.value = value;
            this.label = label;
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node2.value-node1.value;
            }
        });
        for(int i = 0;i<values.length;i++)
            queue.add(new Node(values[i],labels[i]));
        Map<Integer,Integer> label_use = new HashMap<>();
        int ans = 0;
        int count = 0;
        while(queue.size()!=0&&count!=num_wanted){
            Node node = queue.poll();
            int time = label_use.getOrDefault(node.label,0);
            if(time==use_limit)
                continue;
            else{
                count++;
                ans+=node.value;
                label_use.put(node.label,time+1);
            }
        }
        return ans;
    }
}
