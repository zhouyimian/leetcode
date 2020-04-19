package com.km.WeeklyContest185;

public class Minimum_Number_of_Frogs_Croaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int ccount = 0,rcount = 0,ocount = 0,acount = 0;
        int ans = 0;
        for(Character c:croakOfFrogs.toCharArray()){
            if(c=='c'){
                ccount++;
            }else if(c=='r'){
                ccount--;
                rcount++;
            }else if(c=='o'){
                rcount--;
                ocount++;
            }else if(c=='a'){
                ocount--;
                acount++;
            }else{
                acount--;
            }
            if(ccount<0||rcount<0||ocount<0||acount<0)
                return -1;
            ans = Math.max(ans,ccount+rcount+ocount+acount);
        }
        if(ccount==0&&rcount==0&&ocount==0&&acount==0)
            return ans;
        return -1;
    }

    public static void main(String[] args) {
        Minimum_Number_of_Frogs_Croaking test = new Minimum_Number_of_Frogs_Croaking();
        System.out.println(test.minNumberOfFrogs("crcoakroak"));
    }
}
