package com.km.WeeklyContest165;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number_of_Burgers_with_No_Waste_of_Ingredients {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if(tomatoSlices==0&&cheeseSlices==0)
            return Arrays.asList(0,0);
        for(int i = 0;i<cheeseSlices;i++){
            if(4*i+2*(cheeseSlices-i)==tomatoSlices){
                return Arrays.asList(i,cheeseSlices-i);
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Number_of_Burgers_with_No_Waste_of_Ingredients test = new Number_of_Burgers_with_No_Waste_of_Ingredients();
        System.out.println(test.numOfBurgers(0,0));
    }
}
