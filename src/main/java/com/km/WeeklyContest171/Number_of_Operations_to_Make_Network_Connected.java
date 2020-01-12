package com.km.WeeklyContest171;

import java.util.HashSet;
import java.util.Set;

public class Number_of_Operations_to_Make_Network_Connected {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        int[] parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        for(int i = 0;i<connections.length;i++){
            if(connections[i][0]>connections[i][1]){
                int temp = connections[i][0];
                connections[i][0] = connections[i][1];
                connections[i][1] = temp;
            }
            int parentA = findParent(connections[i][0],parent);
            int parentB = findParent(connections[i][1],parent);
            if(parentA!=parentB){
                parent[parentB] = parentA;
            }
        }
        for(int i = 0;i<n;i++){
            findParent(i,parent);
        }
        Set<Integer> set = new HashSet<>();
        for(int num:parent){
            set.add(num);
        }
        return set.size()-1;
    }

    private int findParent(int num,int[] parent) {
        if(num!=parent[num]){
            parent[num] = findParent(parent[num],parent);
        }
        return parent[num];
    }

    public static void main(String[] args) {
        Number_of_Operations_to_Make_Network_Connected test = new Number_of_Operations_to_Make_Network_Connected();
        int[][] connections = {{0,1},{0,2},{3,4},{2,3}};
        System.out.println(test.makeConnected(5,connections));
    }
}
