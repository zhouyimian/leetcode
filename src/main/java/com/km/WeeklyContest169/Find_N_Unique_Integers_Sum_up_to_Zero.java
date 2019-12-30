package com.km.WeeklyContest169;

public class Find_N_Unique_Integers_Sum_up_to_Zero {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int count = n / 2;
        if (count == 0) {
            ans[0] = 0;
            return ans;
        } else {
            int index = 0;
            while (index != n) {
                ans[index++] = count;
                if (index != n)
                    ans[index++] = -count;
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Find_N_Unique_Integers_Sum_up_to_Zero test = new Find_N_Unique_Integers_Sum_up_to_Zero();
        int[] ans = test.sumZero(2);
        for (int num : ans)
            System.out.println(num);
    }
}
