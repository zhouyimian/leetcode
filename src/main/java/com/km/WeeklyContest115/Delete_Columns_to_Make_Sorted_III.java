package com.km.WeeklyContest115;

public class Delete_Columns_to_Make_Sorted_III {
    public int minDeletionSize(String[] A) {
        int ans=A[0].length()-1;
        int length=A.length;
        int[] dp=new int[A[0].length()];
        for(int i=0;i<A[0].length();i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                boolean flag=true;
                for(int k=0;k<length;k++){
                    if(A[k].charAt(j)>A[k].charAt(i)){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            ans=Math.min(ans,A[0].length()-dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s={"babca","bbazb","aaabab"};
        Delete_Columns_to_Make_Sorted_III test=new Delete_Columns_to_Make_Sorted_III();
        System.out.println(test.minDeletionSize(s));
    }
}
