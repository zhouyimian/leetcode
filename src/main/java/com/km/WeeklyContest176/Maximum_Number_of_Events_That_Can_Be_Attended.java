package com.km.WeeklyContest176;

import java.util.*;

public class Maximum_Number_of_Events_That_Can_Be_Attended {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = events.length;
        for (int d = 1; d <= 100000; ++d) {
            while (i < n && events[i][0] == d)
                pq.add(events[i++][1]);
            while (pq.size() > 0 && pq.peek() < d)
                pq.poll();
            if (pq.size() > 0) {
                pq.poll();
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] events = {{1,5},{1,5},{1,5},{2,3},{2,3}};
        Maximum_Number_of_Events_That_Can_Be_Attended test = new Maximum_Number_of_Events_That_Can_Be_Attended();
        System.out.println(test.maxEvents(events));
    }
}
