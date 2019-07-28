package com.km.WeeklyContest147;

public class Largest_1_Bordered_Square {
    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                for (int m = i; m < grid.length; m++) {
                    for (int n = 0; n < grid[m].length; n++) {
                        int temp = sqart(i, j, m, n, grid);
                        if (temp > ans) {
                            ans = temp;
                        }

                    }
                }
            }
        }
        return ans;
    }

    private int sqart(int i, int j, int m, int n, int[][] grid) {
        if (i == m && j == n)
            return grid[i][j];
        else {
            if (Math.abs(i - m) != Math.abs(j - n))
                return 0;
            int count = 0;
            int bigline = i >= m ? i : m;
            int smallline = i >= m ? m : i;
            int bigcolumn = j >= n ? j : n;
            int smallcolumn = j >= n ? n : j;
            for (int startline = smallline; startline <= bigline; startline++) {
                if (grid[startline][smallcolumn] == 0)
                    return 0;
            }
            for (int startline = smallline; startline <= bigline; startline++) {
                if (grid[startline][bigcolumn] == 0)
                    return 0;
            }
            for (int startcolumn = smallcolumn; startcolumn <= bigcolumn; startcolumn++) {
                if (grid[smallline][startcolumn] == 0)
                    return 0;
            }
            for (int startcolumn = smallcolumn; startcolumn <= bigcolumn; startcolumn++) {
                if (grid[bigline][startcolumn] == 0)
                    return 0;
            }
            return (Math.abs(i - m) + 1) * (Math.abs(i - m) + 1);
        }
    }


    public static void main(String[] args) {
        Largest_1_Bordered_Square test = new Largest_1_Bordered_Square();
        int[][] grid = {
                {1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 1},};
        System.out.println(test.largest1BorderedSquare(grid));
    }

}
