package com.km.WeeklyContest111;

public class Delete_Columns_to_Make_Sorted {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j-1].charAt(i) > A[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("abcde");
        sb.deleteCharAt(2);
        System.out.println(sb.toString());
    }
}
