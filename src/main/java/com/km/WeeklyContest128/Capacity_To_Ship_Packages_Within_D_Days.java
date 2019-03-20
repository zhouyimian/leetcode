package com.km.WeeklyContest128;

public class Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int num:weights)
            sum+=num;
        int low = 1;
        int high = sum;
        while(low<=high){
            int mid = low+(high-low)/2;
            int day = deal(weights,mid);
            if(day==Integer.MAX_VALUE){
                low = mid+1;
                continue;
            }
            if(day>D){
                low = mid+1;
            }else if(day<=D){
                ans = Math.min(ans,mid);
                high=mid-1;
            }
        }
        return ans;
    }
    public int deal(int[] weights,int weigh){

        for(int num:weights){
            if(num>weigh)
                return Integer.MAX_VALUE;
        }
        int days = 0;
        int count = weights[0];
        for(int i = 1;i<weights.length;i++){
            if(count+weights[i]<=weigh){
                count+=weights[i];
            }
            else{
                days++;
                count = weights[i];
            }
        }
        return days+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        Capacity_To_Ship_Packages_Within_D_Days test = new Capacity_To_Ship_Packages_Within_D_Days();
        System.out.println(test.shipWithinDays(nums,5));
    }
}
