package com.km;

import java.util.*;


public class AppTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int filterlength = 0,filterx=-1,filtery=-1;
        int[][] temps = new int[length][2];
        for (int i = 0; i < length; i++){
            temps[i][0] = sc.nextInt();
            temps[i][1] = sc.nextInt();
            if(temps[i][0]*temps[i][1]>=filterx*filtery){
                filterx = temps[i][0];
                filtery = temps[i][1];
            }
        }
        for(int i = 0;i<length;i++){
            if(temps[i][0]<filterx&&temps[i][1]<filtery)
                filterlength++;
        }
        filterlength = length-filterlength;
        int[][] nodes = new int[filterlength][2];
        int count = 0;
        for(int i = 0;i<length;i++){
            if(temps[i][0]<filterx&&temps[i][1]<filtery) {
                continue;
            }else{
                nodes[count][0] = temps[i][0];
                nodes[count][1] = temps[i][1];
                count++;
            }
        }
        Arrays.sort(nodes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int maxX = -1;
        for (int i = 0; i < filterlength; i++) {
            if (nodes[i][0] >= maxX) {
                maxX = nodes[i][0];
                System.out.println(nodes[i][0] + " " + nodes[i][1]);
            }
        }
    }
}
