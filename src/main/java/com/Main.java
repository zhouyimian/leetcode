package com;

import java.util.*;

public class Main {
    public int minJump(int[] jump) {
        int[] beyond = new int[jump.length];
        int[] target = new int[jump.length];
        Arrays.fill(target, -1);
        target[0] = 0;
        for (int i = 0; i < jump.length; i++)
            beyond[i] = dfs(jump, beyond, i);
        int now = 0;
        int count = 0;
        while (now < jump.length) {
            now += jump[now];
            if (now >= jump.length)
                break;
            target[now] = ++count;
        }
        int[] rightMinCount = new int[jump.length];
        int min = target[jump.length - 1];
        rightMinCount[jump.length - 1] = Integer.MAX_VALUE;
        for (int i = jump.length - 2; i > 0; i--) {
            if (target[i + 1] != -1)
                min = Math.min(min, target[i + 1]);
            rightMinCount[i] = min + 1;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < jump.length; i++) {
            if (target[i] == -1)
                ans = Math.min(ans, rightMinCount[i] + beyond[i]);
            else
                ans = Math.min(ans, beyond[i]+Math.min(target[i],rightMinCount[i]));
        }
        return ans;
    }

    private int dfs(int[] jump, int[] beyond, int now) {
        if (beyond[now] != 0)
            return beyond[now];
        if (jump[now] + now >= beyond.length)
            beyond[now] = 1;
        else
            beyond[now] = dfs(jump, beyond, now + jump[now]) + 1;
        return beyond[now];
    }

    public static void main(String[] args) {
        Main test = new Main();
        int[] jump = {2, 5, 1, 1, 1, 1};
        System.out.println(test.minJump(jump));
    }
}
