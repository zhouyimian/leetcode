package com.km.leetcode;

public class Global_and_Local_Inversions {
	int[] c;

	public boolean isIdealPermutation(int[] A) {
		int local = 0;
		int glo = 0;
		c = new int[A.length];
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1])
				local++;
		}

		for (int i = 0; i < A.length; i++) {
			insert(A[i], 1);
			glo += i - getsum(A[i]);
		}
		return glo==local;
	}

	int getsum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += c[i];
			i -= lowbit(i);
		}
		return sum;
	}

	int lowbit(int i) {
		return i & (-i);
	}

	int insert(int i, int x) {
		while (i < c.length) {
			c[i] += x;
			i += lowbit(i);
		}
		return 0;
	}
}
