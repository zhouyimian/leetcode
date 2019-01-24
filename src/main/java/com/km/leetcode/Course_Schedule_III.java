package com.km.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Course_Schedule_III {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0]-a[0];
            }
        });
        int length = courses.length;
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int currentTime = 0;
        for (int i = 0; i < length; i++) {
            currentTime+=courses[i][0];
            queue.add(courses[i]);
            if(currentTime>courses[i][1])
                currentTime-=queue.poll()[0];
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] nums ={{100,200},{200,1300},{1000,1250},{2000,3200}};
        Course_Schedule_III test = new Course_Schedule_III();
        System.out.println(test.scheduleCourse(nums));
    }
}
