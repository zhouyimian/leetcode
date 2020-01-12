package com.km.WeeklyContest171;

import java.util.*;

public class Minimum_Distance_to_Type_a_Word_Using_Two_Fingers {
    class NodePair{
        int distinct;
        Character c1;
        Character c2;
        public NodePair(Character c1,Character c2,int distinct){
            this.c1 = c1;
            this.c2 = c2;
            this.distinct = distinct;
        }
    }
    public int minimumDistance(String word) {
        int ans = 0;
        Map<Character,Integer[]> map = new HashMap<>();
        Map<Character,Integer> count = new HashMap<>();
        PriorityQueue<NodePair> queue = new PriorityQueue<>(new Comparator<NodePair>() {
            @Override
            public int compare(NodePair o1, NodePair o2) {
                return o1.distinct-o2.distinct;
            }
        });
        buildMap(map);
        for(int i = 0;i<word.length();i++){
            count.put(word.charAt(i),count.getOrDefault(word.charAt(i),0)+1);
        }
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        for(int i = 0;i<chars.length;i++){
            for(int j = i+1;j<chars.length;j++){
                queue.add(new NodePair(chars[i],chars[j],cal(chars[i],chars[j],map)));
            }
        }
        while (queue.size()!=0&&count.size()!=0){
            NodePair pair = queue.poll();
            while (count.containsKey(pair.c1)&&count.get(pair.c1)!=0&&count.containsKey(pair.c2)&&count.get(pair.c2)!=0){
                ans+=pair.distinct;
                if(count.get(pair.c1)==1){
                    count.remove(pair.c1);
                }else{
                    count.put(pair.c1,count.get(pair.c1)-1);
                }
                if(count.get(pair.c2)==1){
                    count.remove(pair.c2);
                }else{
                    count.put(pair.c2,count.get(pair.c2)-1);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        if(count.size()!=0){
            char c = count.keySet().iterator().next();
            for(int i = 0;i<chars.length;i++){
                if(chars[i]!=c){
                    min = Math.min(min,cal(c,chars[i],map));
                }
            }
            return ans+min;
        }
        return ans;
    }

    private int cal(char a, char b, Map<Character, Integer[]> map) {
        Integer[] numsA = map.get(a);
        Integer[] numsB = map.get(b);
        return Math.abs(numsA[0]-numsB[0])+Math.abs(numsA[1]-numsB[1]);
    }

    private void buildMap(Map<Character, Integer[]> map) {
        map.put('A', new Integer[]{0,0});
        map.put('B', new Integer[]{0,1});
        map.put('C', new Integer[]{0,2});
        map.put('D', new Integer[]{0,3});
        map.put('E', new Integer[]{0,4});
        map.put('F', new Integer[]{0,5});
        map.put('G', new Integer[]{1,0});
        map.put('H', new Integer[]{1,1});
        map.put('I', new Integer[]{1,2});
        map.put('J', new Integer[]{1,3});
        map.put('K', new Integer[]{1,4});
        map.put('L', new Integer[]{1,5});
        map.put('M', new Integer[]{2,0});
        map.put('N', new Integer[]{2,1});
        map.put('O', new Integer[]{2,2});
        map.put('P', new Integer[]{2,3});
        map.put('Q', new Integer[]{2,4});
        map.put('R', new Integer[]{2,5});
        map.put('S', new Integer[]{3,0});
        map.put('T', new Integer[]{3,1});
        map.put('U', new Integer[]{3,2});
        map.put('V', new Integer[]{3,3});
        map.put('W', new Integer[]{3,4});
        map.put('X', new Integer[]{3,5});
        map.put('Y', new Integer[]{4,0});
        map.put('Z', new Integer[]{4,1});
    }

    public static void main(String[] args) {
        Minimum_Distance_to_Type_a_Word_Using_Two_Fingers test = new Minimum_Distance_to_Type_a_Word_Using_Two_Fingers();
        System.out.println(test.minimumDistance("YEAR"));
    }
}
