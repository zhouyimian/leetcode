package com.Biweekly.BiweeklyContest1;

public class Fixed_Point {
    public int fixedPoint(int[] A) {
        int length = A.length;
        for(int i = 0;i<length;i++)
            if(A[i]==i)
                return i;
        return -1;
    }
}
