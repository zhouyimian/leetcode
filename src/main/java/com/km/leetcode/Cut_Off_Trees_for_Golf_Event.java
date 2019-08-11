package com.km.leetcode;

import java.util.*;

class Tree{
    int x;
    int y;
    int high;
    public Tree(int x,int y,int high){
        this.x = x;
        this.y = y;
        this.high = high;
    }

    int[][] dire = {{-1,0},{0,-1},{1,0},{0,1}};
    int line;
    int column;
    public int cutOffTree(List<List<Integer>> forest) {
        int ans = 0;
        if(forest==null||forest.size()==0||forest.get(0).size()==0)
            return 0;
        line = forest.size();
        column = forest.get(0).size();
        PriorityQueue<Tree> treeHigh = new PriorityQueue<>(Comparator.comparingInt(o -> o.high));
        for(int i = 0;i<forest.size();i++){
            for(int j = 0;j<forest.get(0).size();j++){
                if(forest.get(i).get(j)>1)
                    treeHigh.add(new Tree(i,j,forest.get(i).get(j)));
            }
        }
        int curX = 0;
        int curY = 0;
        while (treeHigh.size()!=0){
            Tree tree = treeHigh.poll();
            int step = BFS(curX,curY,tree.x,tree.y,forest);
            if(step==-1)
                return -1;
            else{
                ans+=step;
                curX = tree.x;
                curY = tree.y;
            }
        }
        return ans;
    }

    private int BFS(int curX, int curY, int targetX, int targetY,List<List<Integer>> forest) {
        if(curX==targetX&&curY==targetY)
            return 0;
        int step = 0;
        List<Tree> queue = new ArrayList<>();
        boolean[][] vis = new boolean[line][column];
        vis[curX][curY] = true;
        queue.add(new Tree(curX,curY,-1));
        while (queue.size()!=0){
            List<Tree> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                Tree cur = queue.get(i);
                for(int j = 0;j<4;j++){
                    int x = cur.x+dire[j][0];
                    int y = cur.y+dire[j][1];
                    if(check(x,y,vis,forest)){
                        vis[x][y] = true;
                        if(x==targetX&&y==targetY){
                            forest.get(x).set(y,1);
                            return step+1;
                        }
                        temp.add(new Tree(x,y,-1));
                    }
                }
            }
            queue.clear();
            queue.addAll(temp);
            step++;
        }
        return -1;
    }

    private boolean check(int x, int y, boolean[][] vis,List<List<Integer>> forest) {
        if(x<0||y<0||x>=vis.length||y>=vis[0].length||vis[x][y]||forest.get(x).get(y)==0)
            return false;
        return true;
    }
}
