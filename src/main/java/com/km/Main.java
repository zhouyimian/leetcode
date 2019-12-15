package com.km;


public class Main {
    int num = 0;

    public synchronized void addnum(){
        this.num++;
    }

    public static void main(String[] args) {
        Main test = new Main();
        for(int i = 0;i<20;i++){
            new Thread(()->{
                for(int j = 0;j<1000;j++) {
                    test.addnum();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(test.num);
    }
}
