package com.km;


import java.util.Map;
import java.util.TreeMap;

public class Main {
//    public String longestDiverseString(int a, int b, int c) {
//        StringBuilder ans = new StringBuilder();
//        int maxLength = a+b+c;
//        TreeMap<Character,Integer> map = new TreeMap<>();
//        map.put('a',a);
//        map.put('b',b);
//        map.put('c',c);
//        while (ans.length()<maxLength){
//            String[] nowMax = findMax(map);
//            if(Integer.parseInt(splits[1])>2){
//                ans.append(splits[0]+splits[0]);
//                if(!tempQueue.isEmpty())
//                    queue.add(tempQueue.poll());
//                tempQueue.add(splits[0]+"_"+(Integer.parseInt(splits[1])-2));
//                if(queue.size()==0)
//                    break;
//                else{
//                    nowMax = queue.poll();
//                    splits = nowMax.split("_");
//                    if(Integer.parseInt(splits[1])>2){
//                        ans.append(splits[0]+splits[0]);
//                        queue.add(tempQueue.poll());
//                        tempQueue.add(splits[0]+"_"+(Integer.parseInt(splits[1])-2));
//                    }else{
//                        for(int i = 0;i<Integer.parseInt(splits[1]);i++){
//                            ans.append(splits[0]);
//                        }
//                    }
//                }
//            }else{
//                for(int i = 0;i<Integer.parseInt(splits[1]);i++){
//                    ans.append(splits[0]);
//                }
//            }
//        }
//        return ans.toString();
//    }
//
//    private String[] findMax(TreeMap<Character, Integer> map) {
//        String[] res = new String[2];
//        int maxCount = 0;
//        for(Map.Entry<Character,Integer> entry:map.entrySet()){
//            Character key = entry.getKey();
//            int value = entry.getValue();
//            if(value>maxCount){
//                maxCount = value;
//                res[0] = value+"";
//            }
//        }
//        res[1] = maxCount+"";
//        return new String[0];
//    }
//
//    public static void main(String[] args) {
//        Main test = new Main();
//        System.out.println(test.longestDiverseString(1,1,7));
//    }
}
