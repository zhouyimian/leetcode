package com.km;

public class test {
    public static void main(String[] args) {
        String s = new String("Find Latest Group of Size M");
        String kuohao = dealkuohao(s);
        String timu = dealtimu(s);
        System.out.println(kuohao);
        System.out.println(timu);
    }

    private static String dealtimu(String s) {
        s = s.replace(" ","_");
        s = s.replace("-","_");
        s = s.replace("'","_");
        return s;
    }

    private static String dealkuohao(String s) {
        s = s.replace("[","{");
        s = s.replace("]","}");
        return s;
    }
}
