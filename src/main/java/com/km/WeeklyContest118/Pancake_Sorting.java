package com.km.WeeklyContest118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pancake_Sorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        int tempmax;
        int undeallen = A.length - 1;
        for (int i = A.length; i > 0; i--) {
            for (int j = 0; j <= undeallen; j++) {
                if (A[j] == i) {
                    if (j + 1 != i) {
                        reverse(A, j);
                        ans.add(j+1);
                        reverse(A, undeallen);
                        ans.add(undeallen+1);
                    }
                    undeallen--;
                    break;
                }
            }
        }
        return ans;
    }

    private void reverse(int[] nums, int end) {
        int temp;
        for (int i = 0; i <= end / 2; i++) {
            temp = nums[i];
            nums[i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums={2,1,3};
        Pancake_Sorting test=new Pancake_Sorting();
        for(int num:test.pancakeSort(nums))
            System.out.println(num);
    }
}
