package com.km.WeeklyContest115;

public class Regions_Cut_By_Slashes {
    int ans;
    int[] parent;
    int length;
    public int regionsBySlashes(String[] grid) {
        length=grid.length;
        parent=new int[length*length*4];
        ans=length*length*4;
        for(int i=0;i<length*length*4;i++)  parent[i]=i;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(i>0) union(point(i-1,j,2),point(i,j,0));
                if(j>0) union(point(i,j-1,1),point(i,j,3));
                if(grid[i].charAt(j)!='/'){
                    union(point(i,j,0),point(i,j,1));
                    union(point(i,j,3),point(i,j,2));
                }
                if(grid[i].charAt(j)!='\\'){
                    union(point(i,j,0),point(i,j,3));
                    union(point(i,j,1),point(i,j,2));
                }
            }
        }
        return ans;
    }

    private int point(int i, int j, int pos) {
        return (i*length+j)*4+pos;
    }

    private void union(int x,int y) {
        int parent_x=find(x);
        int parent_y=find(y);
        if(parent_x!=parent_y){
            parent[parent_x]=parent_y;
            ans--;
        }
    }
    public int find(int x){
        if(x!=parent[x])
            x=find(parent[x]);
        return parent[x];
    }
}
