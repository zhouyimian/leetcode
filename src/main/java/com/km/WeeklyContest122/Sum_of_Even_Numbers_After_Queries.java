package com.km.WeeklyContest122;

import com.sun.org.apache.xerces.internal.dom.AttrNSImpl;

public class Sum_of_Even_Numbers_After_Queries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int result = 0;
        for (int num : A) {
            if (num % 2 == 0)
                result += num;
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) {
                if (val % 2 == 0)
                    result += val;
                else
                    result -= A[index];
            } else {
                if (val % 2 == 0) {
                } else
                    result += (A[index] + val);
            }
            ans[i] = result;
            A[index] += val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        Sum_of_Even_Numbers_After_Queries test = new Sum_of_Even_Numbers_After_Queries();
        for (int num : test.sumEvenAfterQueries(A, queries))
            System.out.println(num);
    }
}
