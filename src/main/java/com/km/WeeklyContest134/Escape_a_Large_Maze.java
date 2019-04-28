package com.km.WeeklyContest134;

import java.util.*;

public class Escape_a_Large_Maze {
    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    int[][] dire = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(source[0], source[1]));
        HashSet<Node> blockSet = new HashSet<>();
        HashSet<Node> visit = new HashSet<>();
        for (int i = 0; i < blocked.length; i++) {
            blockSet.add(new Node(blocked[i][0], blocked[i][1]));
        }
        visit.add(new Node(source[0],source[1]));
        while (list.size() != 0) {
            List<Node> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                for (int j = 0; j < 4; j++) {
                    int x = node.x + dire[j][0];
                    int y = node.y + dire[j][1];
                    if (check(x, y)) {
                        Node n = new Node(x, y);
                        if (x == target[0] && y == target[1])
                            return true;
                        if (!visit.contains(n)&&!blockSet.contains(n)) {
                            visit.add(n);
                            temp.add(new Node(x, y));
                        }
                    }
                }
            }
            list.clear();
            list.addAll(temp);
            if (visit.size() >= 20000)
                return true;
        }
        return false;
    }

    private boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= 1000000 || y >= 1000000)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[] source = {0,0};
        int[][] block ={};
        int[] target = {999999,999999};
        Escape_a_Large_Maze test = new Escape_a_Large_Maze();
        System.out.println(test.isEscapePossible(block,source,target));
    }
}
