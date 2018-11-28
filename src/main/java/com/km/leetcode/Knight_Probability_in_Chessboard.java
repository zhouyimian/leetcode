package com.km.leetcode;

public class Knight_Probability_in_Chessboard {
	static double[][][] gl = new double[26][26][101];

	public static double knightProbability(int N, int K, int r, int c) {
		if (r < 0 || c < 0||r>=N||c>=N)
			return 0;
		if (K == 0)
			return 1;
		if (gl[r][c][K] != 0)
			return gl[r][c][K];
		gl[r][c][K] = 1.0 / 8
				* (knightProbability(N, K - 1, r - 2, c - 1) + knightProbability(N, K - 1, r - 1, c - 2)
						+ knightProbability(N, K - 1, r - 2, c + 1) + knightProbability(N, K - 1, r - 1, c + 2)
						+ knightProbability(N, K - 1, r + 2, c - 1) + knightProbability(N, K - 1, r + 1, c - 2)
						+ knightProbability(N, K - 1, r + 2, c + 1) + knightProbability(N, K - 1, r + 1, c + 2));
		return gl[r][c][K];
	}

	public static void main(String[] args) {
		System.out.println(knightProbability(3,2,0,0));
	}

}
