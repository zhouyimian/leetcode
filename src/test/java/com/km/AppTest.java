package com.km;

import java.util.*;

public class AppTest {
    static class Node{
        int numA;
        int numB;
        int res;
        public Node(int numA,int numB,int m){
            this.numA = numA;
            this.numB = numB;
            this.res = (numA+numB)%m;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.res-o1.res;
            }
        });
        int[] numsA = new int[n];
        int[] numsB = new int[n];
        Map<Integer,Integer> mapA = new HashMap<>();
        Map<Integer,Integer> mapB = new HashMap<>();
        for(int i = 0 ;i<n;i++){
            numsA[i] = sc.nextInt();
            mapA.put(numsA[i],mapA.getOrDefault(numsA[i],0)+1);
        }
        for(int i = 0 ;i<n;i++){
            numsB[i] = sc.nextInt();
            mapB.put(numsB[i],mapB.getOrDefault(numsB[i],0)+1);
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                queue.add(new Node(numsA[i],numsB[j],m));
            }
        }
        int[] ans = new int[n];
        int index = 0;
        while (index!=ans.length){
            Node node = queue.poll();
            if(mapA.containsKey(node.numA)&&mapB.containsKey(node.numB)){
                ans[index++] = node.res;
                if(mapA.get(node.numA)==1){
                    mapA.remove(node.numA);
                }else{
                    mapA.put(node.numA,mapA.get(node.numA)-1);
                }
                if(mapB.get(node.numB)==1){
                    mapB.remove(node.numB);
                }else{
                    mapB.put(node.numB,mapB.get(node.numB)-1);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(i!=n-1)
                System.out.print(ans[i]+" ");
            else
                System.out.println(ans[i]);
        }
    }
}
