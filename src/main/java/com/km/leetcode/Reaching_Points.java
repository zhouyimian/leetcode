package com.km.leetcode;

public class Reaching_Points {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx>=sx&&ty>=sy){
            if(tx>ty){
                if(ty==sy)
                    return (tx-sx)%sy==0;
                tx%=ty;
            }
            else{
                if(tx==sx)
                    return (ty-sy)%sx==0;
                ty%=tx;
            }
        }
        return false;
    }
}
