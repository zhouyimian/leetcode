package com.km;


import org.apache.commons.cli.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println(dealString("Jump Game V"));
        System.out.println(dealkuohao("[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]"));
    }
    public static String dealString(String s){
        s = s.replace(" ","_");
        s = s.replace(",","_");
        s = s.replace("-","_");
        return s;
    }
    public static String dealkuohao(String s){
        s = s.replace("[","{");
        s = s.replace("]","}");
        return s;
    }
}
