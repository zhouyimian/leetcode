package com.km.WeeklyContest163;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class Minimum_Moves_to_Move_a_Box_to_Their_Target_Location {
    public int minPushBox(char[][] grid) {
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int startX = 0,startY = 0,boxX = 0,boxY = 0,targetX = 0,targetY = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]=='S'){
                    startX = i;
                    startY = j;
                }
                if(grid[i][j]=='B'){
                    boxX = i;
                    boxY = j;
                }
                if(grid[i][j]=='T'){
                    targetX = i;
                    targetY = j;
                }
            }
        }
        int[] parent = buildSet(grid);
        int personParent = find(startX*n+startY,parent);
        int boxParent = find(boxX*n+boxY,parent);
        int targetParent = find(targetX*n+targetY,parent);
        if(!(personParent==boxParent&&boxParent==targetParent))
            return -1;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.add(new int[]{boxX*n+boxY,startX*n+startY});
        visit.add((boxX*n+boxY+","+startX*n+startY));
        int ans = 0;
        while (queue.size()!=0){
            for(int size = queue.size();size>0;size--){
                int[] p = queue.poll();
                if(p[0]==targetX*n+targetY)
                    return ans;
                int r = p[0]/n,c = p[0]%n;
                grid[r][c] = '#';
                parent = buildSet(grid);
                for(int i = 0;i<4;i++){
                    int x = r+dir[i][0],y = c+dir[i][1];
                    int rx = r-dir[i][0],ry = c-dir[i][1];

                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#' && rx >= 0 && rx < m && ry >= 0 && ry < n && grid[rx][ry] != '#') {

                        if(find( rx * n + ry,parent) == find(p[1],parent) && visit.add((x * n + y) + "," + p[0])) {
                            queue.offer(new int[]{x * n + y, p[0]});
                        }
                    }
                }
                grid[r][c] = (char)(ans + '0');
            }
            ans++;
        }
        return -1;
    }

    private int[] buildSet(char[][] grid) {
        int[] parent = new int[grid.length*grid[0].length];
        for(int i = 0;i<parent.length;i++) parent[i] = i;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]!='#'){
                    if(i > 0 && grid[i-1][j] != '#') union(parent, (i-1)*n+j, i*n+j);
                    if(i < m-1 && grid[i+1][j] != '#') union(parent, (i+1)*n+j, i*n+j);
                    if(j > 0 && grid[i][j-1] != '#') union(parent, i*n+j-1, i*n+j);
                    if(j < n-1 && grid[i][j+1] != '#') union(parent, i*n+j+1, i*n+j);
                }
            }
        }
        return parent;
    }

    private void union(int[] parent, int a, int b) {
        int parentA = find(a,parent);
        int parentB = find(b,parent);
        if(parentA!=parentB)
            parent[parentA] = parentB;
    }

    private int find(int p, int[] parent) {
        return parent[p]=p==parent[p]?p:find(parent[p],parent);
    }
}
