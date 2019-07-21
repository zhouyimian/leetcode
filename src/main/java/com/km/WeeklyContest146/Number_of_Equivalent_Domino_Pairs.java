package com.km.WeeklyContest146;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number_of_Equivalent_Domino_Pairs {
    class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    Map<Node,Integer> map = new HashMap<>();
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int length = dominoes.length;
        for(int i = 0;i<length;i++){
            deal(dominoes[i]);
            Node node = new Node(dominoes[i][0],dominoes[i][1]);
            ans+=map.getOrDefault(node,0);
            map.put(node,map.getOrDefault(node,0)+1);
        }
        return ans;
    }
    public void deal(int[] nums){
        if(nums[0]>nums[1]){
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
        }
    }
}
