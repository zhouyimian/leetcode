package com.km.WeeklyContest143;

public class Filling_Bookcase_Shelves {
    int[][] dp;
    public int minHeightShelves(int[][] books, int shelf_width) {
        dp = new int[books.length+1][shelf_width+1];
        return minHeight(books,0,shelf_width,0,shelf_width);
    }

    private int minHeight(int[][] books, int cur, int width_left, int curHeight, int shelf_width) {
        if(cur==books.length)
            return curHeight;
        if(dp[cur][width_left]!=0)
            return dp[cur][width_left];
        if(width_left>=books[cur][0]){
            dp[cur][width_left] = Math.min(
                    minHeight(books,cur+1,width_left-books[cur][0],Math.max(curHeight,books[cur][1]),shelf_width),
                    curHeight+minHeight(books,cur+1,shelf_width-books[cur][0],books[cur][1],shelf_width));
        }else{
            dp[cur][width_left] = curHeight+minHeight(books,cur+1,shelf_width-books[cur][0],books[cur][1],shelf_width);
        }
        return dp[cur][width_left];
    }
}