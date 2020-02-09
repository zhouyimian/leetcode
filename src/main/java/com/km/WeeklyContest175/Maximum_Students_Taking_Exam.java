package com.km.WeeklyContest175;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Students_Taking_Exam {
    char[][] seats;
    int m;
    int n;
    public int maxStudents(char[][] seats) {
        this.seats = seats;
        this.m = seats.length;
        this.n = seats[0].length;
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (seats[i][j] == '.') {
                    res = Math.max(res, bfs(i, j, copy(seats)));
                }
        return res;
    }

    int[][] dirs = {{0, 1}, {0, -1}, {-1, -1}, {-1, 1}};

    private int bfs(int startX, int startY, char[][] seats) {
        seats[startX][startY] = 'X';
        int ans = 0;
        for (int[] dir : dirs) {
            int x = startX + dir[0], y = startY + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (seats[x][y] == '.') seats[x][y] = '#';
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (seats[i][j] == '.')
                    if (checkValid(i, j, seats))
                        banSeat(i, j, seats);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (seats[i][j] == 'X') ans++;
        return ans;
    }

    private void banSeat(int startX, int startY, char[][] seats) {
        seats[startX][startY] = 'X';
        for (int[] dir : dirs) {
            int x = startX + dir[0], y = startY + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            seats[x][y] = '#';
        }
    }

    private boolean checkValid(int startX, int startY, char[][] seats) {
        for (int[] dir : dirs) {
            int x = startX + dir[0], y = startY + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (seats[x][y] == 'X') return false;
        }
        return true;
    }

    private char[][] copy(char[][] seats) {
        char[][] tmp = new char[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                tmp[i][j] = seats[i][j];
        return tmp;
    }

    public static void main(String[] args) {
        char[][] map = new char[][]{{'#','.','#','#','.','#'},{'.','#','#','#','#','.'},{'#','.','#','#','.','#'}};
        Maximum_Students_Taking_Exam test = new Maximum_Students_Taking_Exam();
        System.out.println(test.maxStudents(map));
    }
}
