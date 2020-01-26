package com.km.WeeklyContest173;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Filter_Restaurants_by_Vegan_Friendly__Price_and_Distance {
    class Restaurant{
        int id;
        int rating;
        int veganfriendly;
        int price;
        int distance;
        public Restaurant(int id,int rating,int veganfriendly,int price,int distance){
            this.id = id;
            this.rating = rating;
            this.veganfriendly = veganfriendly;
            this.price = price;
            this.distance = distance;
        }
    }
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> ans = new ArrayList<>();
        List<Restaurant> source = new ArrayList<>();
        for(int i = 0;i<restaurants.length;i++)
            source.add(new Restaurant(restaurants[i][0],restaurants[i][1],restaurants[i][2],restaurants[i][3],restaurants[i][4]));
        if(veganFriendly==1){
            source = filterByVegan(source);
            source = filterByValue(source,maxPrice);
            source = filterByDistinct(source,maxDistance);
        }else{
            source = filterByValue(source,maxPrice);
            source = filterByDistinct(source,maxDistance);
        }
        PriorityQueue<Restaurant> queue = new PriorityQueue<>((res1, res2) -> res1.rating!=res2.rating?res2.rating-res1.rating:res2.id-res1.id);
        for(Restaurant res:source)
            queue.add(res);
        while (!queue.isEmpty()){
            ans.add(queue.poll().id);
        }
        return ans;
    }

    private List<Restaurant> filterByDistinct(List<Restaurant> source, int maxDistance) {
        List<Restaurant> res = new ArrayList<>();
        for(Restaurant restaurant:source){
            if(restaurant.distance<=maxDistance){
                res.add(restaurant);
            }
        }
        return res;
    }

    private List<Restaurant> filterByValue(List<Restaurant> source, int maxPrice) {
        List<Restaurant> res = new ArrayList<>();
        for(Restaurant restaurant:source){
            if(restaurant.price<=maxPrice){
                res.add(restaurant);
            }
        }
        return res;
    }

    private List<Restaurant> filterByVegan(List<Restaurant> source) {
        List<Restaurant> res = new ArrayList<>();
        for(Restaurant restaurant:source){
            if(restaurant.veganfriendly==1){
                res.add(restaurant);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        Filter_Restaurants_by_Vegan_Friendly__Price_and_Distance test = new Filter_Restaurants_by_Vegan_Friendly__Price_and_Distance();
        System.out.println(test.filterRestaurants(nums,1,50,10));
    }
}
