package com.km.WeeklyContest187;

public class Check_If_All_1_s_Are_at_Least_Length_K_Places_Away {
    public boolean kLengthApart(int[] nums, int k) {
        int before = -1;
        int now = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==1){
                if(before==-1){
                    before = i;
                    now = i;
                }else{
                    before = now;
                    now = i;
                    if(now-before-1<k)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Check_If_All_1_s_Are_at_Least_Length_K_Places_Away test = new Check_If_All_1_s_Are_at_Least_Length_K_Places_Away();
        int[] nums = {1,0,0,1,0,1};
        System.out.println(test.kLengthApart(nums,2));
    }
}
