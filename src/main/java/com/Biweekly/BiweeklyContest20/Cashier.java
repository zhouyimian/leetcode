package com.Biweekly.BiweeklyContest20;

import java.util.HashMap;
import java.util.Map;

public class Cashier {
    int curTime;
    int everyTime;
    int discount;
    Map<Integer,Integer> prices;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.curTime = 0;
        this.everyTime = n;
        this.discount = discount;
        this.prices = new HashMap<>();
        for(int i = 0;i<products.length;i++)
            this.prices.put(products[i],prices[i]);
    }

    public double getBill(int[] product, int[] amount) {
        double ans = 0;
        for(int i = 0;i<product.length;i++)
            ans+=(amount[i]*prices.get(product[i]));
        this.curTime++;
        if(this.curTime%this.everyTime==0)
            ans -= (discount * ans) / (100.0);
        return ans;
    }
}
