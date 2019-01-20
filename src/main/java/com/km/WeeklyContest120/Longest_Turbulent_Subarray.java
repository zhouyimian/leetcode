package com.km.WeeklyContest120;

public class Longest_Turbulent_Subarray {
    public int maxTurbulenceSize(int[] A) {
        if(A.length==1)
            return 1;
        if(A.length==2)
            return A[0]!=A[1]?2:1;
        int length = 1;
        int start=0;
        int end=0;
        boolean flag=true,ifbreak=false;
        for(int i=0;i<A.length;i++){
            ifbreak=false;
            start=i;
            int first=start;
            int second=start+1;
            if(second>=A.length||A[first]==A[second])
                continue;
            if(A[first]>A[second])
                flag = true;
            else
                flag = false;
            while(second+1<A.length){
                first++;
                second++;
                if(flag==true&&A[first]<A[second]) {
                    flag=false;
                    continue;
                }
                else if(flag==false&&A[first]>A[second]) {
                    flag=true;
                    continue;
                }
                else {
                    ifbreak=true;
                    break;
                }
            }
            if(ifbreak) {
                length = Math.max(length, first - start + 1);
                i=first-1;
            }
            else {
                length = Math.max(length,A.length-start);
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums={0,1,1,0,1,0,1,1,0,0};
        Longest_Turbulent_Subarray test=new Longest_Turbulent_Subarray();
        System.out.println(test.maxTurbulenceSize(nums));
    }
}
