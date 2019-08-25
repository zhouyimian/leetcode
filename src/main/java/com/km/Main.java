package com.km;

import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String [] srgs) {
        int num = 5;
        check(num);
        System.out.println(num);

    }
    public static void check(int num){
        num--;
    }
}
