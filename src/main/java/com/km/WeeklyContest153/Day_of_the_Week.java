package com.km.WeeklyContest153;

public class Day_of_the_Week {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] b = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        boolean m[] = {false,true,false,true,false,true,false,true,true,false,true,false,true};

        if (month<3)
        {
            year -= 1;
            month += 12;
        }
        int c = year/100,y = year%100;
        int w = c/4 - 2*c +y +(y/4) +(26*(month+1)/10) + day-1;
        return b[(w%7+7)%7];
    }

}
