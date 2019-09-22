package com.km.WeeklyContest154;

public class K_Concatenation_Maximum_Sum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long mod = 1000000007;
        long ans = 0;
        long sum = 0;
        for(int num:arr)
            sum+=num;
        int temp = 0;
        if(k==1){
            for(int num:arr){
                temp+=num;
                if(temp>=ans){
                    ans = temp;
                }
                if(temp<0){
                    temp = 0;
                }
            }
            return (int)(ans%mod);
        }else{
            for(int num:arr){
                temp+=num;
                if(temp>=ans){
                    ans = temp;
                }
                if(temp<0){
                    temp = 0;
                }
            }
            for(int num:arr){
                temp+=num;
                if(temp>=ans){
                    ans = temp;
                }
                if(temp<0){
                    temp = 0;
                }
            }
            if(k==2||sum<=0)
                return (int)(ans%mod);
            else{
                int leftMax = 0;
                int left = leftMax;
                int rightMax = 0;
                int right = rightMax;
                for(int i = 0;i<arr.length;i++){
                    right+=arr[i];
                    rightMax = Math.max(right,rightMax);
                }
                for(int i = arr.length-1;i>=0;i--){
                    left+=arr[i];
                    leftMax = Math.max(left,leftMax);
                }
                ans=Math.max(ans,(k-2)*sum+leftMax+rightMax);
                return (int)(ans%mod);
            }
        }
    }

    public static void main(String[] args) {

    }
}
