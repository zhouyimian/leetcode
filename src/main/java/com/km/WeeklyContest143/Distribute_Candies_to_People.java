package com.km.WeeklyContest143;

public class Distribute_Candies_to_People {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        if (num_people == 1) {
            ans[0] = candies;
            return ans;
        }
        int time = 0;
        int start = 1;
        while (candies > 0) {
            int count = (start + start + num_people - 1) * num_people / 2;
            if (candies >= count) {
                time++;
                candies -= count;
                start = start + num_people;
            } else {
                if (time != 0) {
                    for (int i = 0; i < num_people; i++) {
                        ans[i] = ((i + 1) + ((time - 1) * num_people + (i + 1))) * time / 2;
                    }
                }

                for (int i = 0; i < num_people && candies > 0; i++) {
                    if (candies >= (start + i)) {
                        ans[i] += start + i;
                        candies -= (start + i);
                    } else {
                        ans[i] += candies;
                        candies = 0;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Distribute_Candies_to_People test = new Distribute_Candies_to_People();
        int[] ans = test.distributeCandies(60, 4);
        for (int num : ans)
            System.out.println(num);
    }
}
