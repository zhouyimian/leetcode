package com.km.WeeklyContest149;

public class Day_of_the_Year {
    public int dayOfYear(String date)  {
        int[][] days = {{31,29,31,30,31,30,31,31,30,31,30,31},{31,28,31,30,31,30,31,31,30,31,30,31}};
        String[] temp = date.split("-");
        int[] d = new int[3];
        int ans = 0;
        for(int i = 0;i<3;i++)
            d[i] = Integer.parseInt(temp[i]);
        if((d[0]%400==0)||(d[0]%4==0&&d[0]%100!=0)){
            for(int i = 0;i<d[1]-1;i++)
                ans+=days[0][i];
            ans+=d[2];
        }else{
            for(int i = 0;i<d[1]-1;i++)
                ans+=days[1][i];
            ans+=d[2];
        }
        return ans;
    }

    public static void main(String[] args) {
        Day_of_the_Year test = new Day_of_the_Year();
        System.out.println(test.dayOfYear("2019-02-10"));
    }
}
