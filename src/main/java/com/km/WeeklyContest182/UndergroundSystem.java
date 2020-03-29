package com.km.WeeklyContest182;

import sun.net.www.http.HttpCaptureOutputStream;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    Map<Integer,String[]> in ;
    Map<String,int[]> count;
    public UndergroundSystem() {
        in = new HashMap<>();
        count = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        in.put(id,new String[]{stationName,t+""});
    }

    public void checkOut(int id, String stationName, int t) {
        String[] value = in.remove(id);
        int[] cal = count.getOrDefault(value[0]+"-"+stationName,new int[2]);
        cal[0]+=(t-Integer.parseInt(value[1]));
        cal[1]++;
        count.put(value[0]+"-"+stationName,cal);
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] value = count.get(startStation+"-"+endStation);
        if(value==null)
            return 0.0;
        else
            return (value[0]+0.0)/value[1];
    }

    public static void main(String[] args) {
        UndergroundSystem test = new UndergroundSystem();
        test.checkIn(45,"Leyton",3);
        test.checkIn(45, "Leyton", 3);
        test.checkIn(32, "Paradise", 8);
        test.checkIn(27, "Leyton", 10);
        test.checkOut(45, "Waterloo", 15);
        test.checkOut(27, "Waterloo", 20);
        test.checkOut(32, "Cambridge", 22);
        test.getAverageTime("Paradise", "Cambridge");       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        test.getAverageTime("Leyton", "Waterloo");          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        test.checkIn(10, "Leyton", 24);
        test.getAverageTime("Leyton", "Waterloo");          // return 11.0
        test.checkOut(10, "Waterloo", 38);
        test.getAverageTime("Leyton", "Waterloo");
    }
}
