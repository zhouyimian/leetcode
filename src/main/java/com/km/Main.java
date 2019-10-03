package com.km;


import java.util.*;

public class Main {
    public Object instance = null;
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];
    public static void main(String[] args) {
        Main m1 = new Main();
        Main m2 = new Main();

        m1.instance = m2;
        m2.instance = m1;

//        m1 = null;
//        m2 = null;

        System.gc();
    }

}
