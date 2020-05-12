package com.km.WeeklyContest188;

public class Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    public int countTriplets(int[] arr) {
        int ans = 0;
        int length = arr.length;
        int[] sum = new int[length];
        sum[0] = arr[0];
        for(int i = 1;i<length;i++)
            sum[i] = sum[i-1]^arr[i];
        for(int i = 0;i<length;i++){
            for(int j = i+1;j<length;j++){
                for(int k = j;k<length;k++){
                    if(cal(i,j-1,sum)==cal(j,k,sum))
                        ans++;
                }
            }
        }
        return ans;
    }

    private int cal(int start, int end, int[] sum) {
        if(start==0)
            return sum[end];
        return sum[end]^sum[start-1];
    }

    public static void main(String[] args) {
        Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR test = new Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR();
        int[] arr = {1,1,1,1,1};
        System.out.println(test.countTriplets(arr));
    }
}
