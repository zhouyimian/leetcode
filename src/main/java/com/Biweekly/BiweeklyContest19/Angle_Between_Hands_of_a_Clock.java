package com.Biweekly.BiweeklyContest19;

public class Angle_Between_Hands_of_a_Clock {
    public double angleClock(int hour, int minutes) {
        hour = hour%12;
        double h = hour*30+(double)minutes/2;
        double m = minutes*6;
        double diff = Math.abs(h-m);
        return Math.min(diff,360-diff);
    }

    public static void main(String[] args) {
        Angle_Between_Hands_of_a_Clock test = new Angle_Between_Hands_of_a_Clock();
        System.out.println(test.angleClock(6,5));
    }
}
