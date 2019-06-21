package com.km.WeeklyContest140;

import java.util.HashSet;
import java.util.Set;

public class Letter_Tile_Possibilities {
    int[] vis;
    Set<String> ans = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        vis = new int[tiles.length()];
        dfs(new StringBuilder(""),tiles);
        return ans.size();
    }
    public void dfs(StringBuilder sb,String tiles){
        for(int i = 0;i<tiles.length();i++){
            if(vis[i]==0){
                vis[i] = 1;
                sb.append(tiles.charAt(i));
                ans.add(sb.toString());
                dfs(sb,tiles);
                sb.deleteCharAt(sb.length()-1);
                vis[i] = 0;
            }
        }
    }
}
