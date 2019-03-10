package com.km.WeeklyContest127;

public class Minimum_Domino_Rotations_For_Equal_Row {
    public int minDominoRotations(int[] A, int[] B) {
        int ans = -1;
        boolean flag = true;
        for(int i = 1;i<=6;i++){
            flag = true;
            int countA = 0;
            int countB = 0;
            if(morethanHalf(A,B,i)){
                for(int j = 0;j<A.length;j++){
                    if(A[j]!=i&&B[j]!=i){
                        flag=false;
                        break;
                    }else if(A[j]==i&&B[j]!=i){
                        countB++;
                    }else if(A[j]!=i&&B[j]==i){
                        countA++;
                    }
                }
                if(flag){
                    if(ans==-1)
                        ans = Math.min(countA,countB);
                    else
                        ans = Math.min(ans,Math.min(ans,countA));
                }
            }
        }
        return ans;
    }
    public boolean morethanHalf(int[] A,int[] B,int target){
        int count = 0;
        for(int i = 0;i<A.length;i++){
            if(A[i]==target) count++;
            if(B[i]==target) count++;
        }
        return count>=A.length;
    }
}
