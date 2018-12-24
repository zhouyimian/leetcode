package com.km.WeeklyContest116;

public class Maximum_Width_Ramp {
    public int maxWidthRamp(int[] A) {
        int max=0;
        for(int i=0;i<A.length;i++){
            if(A.length-i<=max)
                break;
            int j=A.length-1;
            while(j>i&&A[j]<A[i]) j--;
            max=Math.max(max,j-i);
            int temp=A[i];
            while(i<A.length-1&&(i+1)<j&&A[i+1]>=temp) i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Maximum_Width_Ramp test=new Maximum_Width_Ramp();
        int[] nums={6,0,8,2,1,5};
        System.out.println(test.maxWidthRamp(nums));
    }
}
