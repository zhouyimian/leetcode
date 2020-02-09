package com.km.WeeklyContest175;

import java.util.*;

public class TweetCounts {
    Map<String,TreeSet<Integer>> store;
    Map<String,Integer> intervals = new HashMap<>();
    public TweetCounts() {
        store = new HashMap<>();
        intervals.put("minute",60);
        intervals.put("hour",3600);
        intervals.put("day",86400);
    }

    public void recordTweet(String tweetName, int time) {
        TreeSet<Integer> set = store.getOrDefault(tweetName,new TreeSet<>());
        set.add(time);
        store.put(tweetName,set);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = store.getOrDefault(tweetName,new TreeSet<>());
        int diff = intervals.get(freq);
        while (startTime+diff-1<=endTime){
            int count = 0;
            for(int i = startTime;i<=startTime+diff-1;i++){
                if(set.contains(i))
                    count++;
            }
            ans.add(count);
            startTime+=diff;
        }
        if(startTime<=endTime){
            int count = 0;
            for(int i = startTime;i<=endTime;i++){
                if(set.contains(i))
                    count++;
            }
            ans.add(count);
        }
        return ans;
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();

        tweetCounts.recordTweet("tweet0", 12);
        tweetCounts.recordTweet("tweet1", 39);
        tweetCounts.recordTweet("tweet2", 81);
        tweetCounts.recordTweet("tweet3", 11);
        tweetCounts.recordTweet("tweet4", 45);
        System.out.println(tweetCounts.getTweetCountsPerFrequency("day", "tweet2", 11, 1532));

        tweetCounts.recordTweet("tweet3", 14);
        tweetCounts.recordTweet("tweet4", 90);
        tweetCounts.recordTweet("tweet3", 13);
        System.out.println(tweetCounts.getTweetCountsPerFrequency("hour", "tweet2", 14, 2203));
    }
}
