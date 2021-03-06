package com.km.WeeklyContest119;

import java.util.Arrays;

public class Largest_Perimeter_Triangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i=A.length;i>=2;i--){
            if(A[i]<A[i-1]+A[i-2])
                return A[i]+A[i-1]+A[i-2];
        }
        return 0;
    }
}
