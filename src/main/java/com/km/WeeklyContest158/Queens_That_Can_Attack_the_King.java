package com.km.WeeklyContest158;

import java.util.*;

public class Queens_That_Can_Attack_the_King {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[] direvis = new boolean[8];
        boolean[][] vis = new boolean[8][8];
        int[][] dire = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        List<List<Integer>> ans = new ArrayList<>();
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < queens.length; i++) {
            set.add(new Point(queens[i][0], queens[i][1]));
        }
        for(int i = 0;i<8;i++){
            int startx = king[0];
            int starty = king[1];
            while (!direvis[i]&&check(startx,starty)){
                if(set.contains(new Point(startx,starty))){
                    direvis[i] = true;
                    ans.add(Arrays.asList(startx,starty));
                    break;
                }
                startx = startx+dire[i][0];
                starty = starty+dire[i][1];
            }
        }
        return ans;
    }

    private boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= 8 || y >= 8)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Queens_That_Can_Attack_the_King test = new Queens_That_Can_Attack_the_King();

    }
}
