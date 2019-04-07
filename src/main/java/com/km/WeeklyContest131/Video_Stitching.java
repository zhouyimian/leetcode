package com.km.WeeklyContest131;

import java.util.Arrays;

public class Video_Stitching {
    public int videoStitching(int[][] clips, int T) {
        int ans = -1;
        for (int i = 0; i < clips.length; i++) {
            if (i != clips.length - 1 && (clips[i][0] >= T || clips[i][1] >= T))
                break;
            if (i == clips.length - 1) {
                if (clips[i][0] >= T || clips[i][1] >= T)
                    break;
                else
                    return ans;
            }
        }
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });
        int start = 0;
        int end = -1;
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] == 0)
                end = clips[i][1];
        }
        if (end >= T)
            return 1;
        ans = 1;
        boolean flag = false;
        while (end < T) {
            flag = false;
            int tempend = end;
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0]>=start&&clips[i][0]<=end&&clips[i][1]>tempend) {
                    tempend = Math.max(tempend,clips[i][1]);
                    flag = true;
                }
            }
            if(flag==false){
                return -1;
            }
            ans++;
            end = tempend;
        }
        return ans;
    }

    public static void main(String[] args) {
        Video_Stitching test = new Video_Stitching();
        int[][] nums = {{0, 4}, {2, 8}};
        System.out.println(test.videoStitching(nums, 5));
    }
}
