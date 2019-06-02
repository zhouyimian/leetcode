package com.km;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(Base2(-1));
    }
    public static String Base2(int num){
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            sb.append(num&1);
            num = num>>1;
        }
        return sb.reverse().toString();
    }
}
