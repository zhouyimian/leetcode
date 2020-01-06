package com.km.WeeklyContest170;

import java.util.*;

public class Get_Watched_Videos_by_Your_Friends {
    class Node{
        String MovieName;
        int count;
        public Node(String MovieName,int count){
            this.MovieName = MovieName;
            this.count = count;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> ans = new ArrayList<>();
        List<List<Integer>> levelFriends = new ArrayList<>();
        levelFriends.add(Arrays.asList(id));
        boolean[] vis = new boolean[friends.length];
        vis[id] = true;
        while (levelFriends.size()!=level+1){
            List<Integer> curFriend = levelFriends.get(levelFriends.size()-1);
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<curFriend.size();i++){
                for(int j = 0;j<friends[curFriend.get(i)].length;j++){
                    if(!vis[friends[curFriend.get(i)][j]]){
                        vis[friends[curFriend.get(i)][j]] = true;
                        temp.add(friends[curFriend.get(i)][j]);
                    }
                }
            }
            levelFriends.add(temp);
        }
        List<Integer> fri = levelFriends.get(levelFriends.size()-1);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.count!=node2.count?node1.count-node2.count:node1.MovieName.compareTo(node2.MovieName);
            }
        });
        Map<String,Integer> count = new HashMap<>();
        for(int i = 0;i<fri.size();i++){
            for(int j = 0 ;j<watchedVideos.get(fri.get(i)).size();j++){
                count.put(watchedVideos.get(fri.get(i)).get(j),count.getOrDefault(watchedVideos.get(fri.get(i)).get(j),0)+1);
            }
        }
        for(Map.Entry<String,Integer> entry:count.entrySet()){
            priorityQueue.add(new Node(entry.getKey(),entry.getValue()));
        }
        while (priorityQueue.size()!=0){
            ans.add(priorityQueue.poll().MovieName);
        }
        return ans;
    }

    public static void main(String[] args) {
        Get_Watched_Videos_by_Your_Friends test = new Get_Watched_Videos_by_Your_Friends();
        List<List<String>> watchedVideos = new ArrayList<>();
        watchedVideos.add(Arrays.asList("A","B"));
        watchedVideos.add(Arrays.asList("C"));
        watchedVideos.add(Arrays.asList("B"));
        watchedVideos.add(Arrays.asList("A","B"));
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        int id = 0, level = 1;
        List<String> ans = test.watchedVideosByFriends(watchedVideos,friends,id,level);
        for(String s:ans)
            System.out.println(s);
    }
}
