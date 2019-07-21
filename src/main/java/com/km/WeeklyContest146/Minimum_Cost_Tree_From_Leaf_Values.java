package com.km.WeeklyContest146;

public class Minimum_Cost_Tree_From_Leaf_Values {
    int ans = 0;
    public int mctFromLeafValues(int[] arr) {
        mctFromLeafValues(0,arr.length-1,arr);
        return ans;
    }
    public int mctFromLeafValues(int start,int end,int[] arr){
        if(start>end)
            return 0;
        else if(start==end)
            return arr[start];
        else if(start+1==end){
            ans+=arr[start]*arr[end];
            return Math.max(arr[start],arr[end]);
        }
        else{
            int maxIndex = start;
            for(int i = start;i<=end;i++){
                if(arr[maxIndex]<arr[i])
                    maxIndex = i;
            }
            int left = mctFromLeafValues(start,maxIndex-1,arr);
            int right = mctFromLeafValues(maxIndex+1,end,arr);
            if(left!=0)
                ans+=arr[maxIndex]*left;
            if(right!=0)
                ans+=arr[maxIndex]*right;
            return arr[maxIndex];
        }
    }

    public static void main(String[] args) {
        Minimum_Cost_Tree_From_Leaf_Values test = new Minimum_Cost_Tree_From_Leaf_Values();
        int[] nums = {6,2,4};
        System.out.println(test.mctFromLeafValues(nums));
    }
}
