package com.km.WeeklyContest113;

public class Largest_Time_for_Given_Digits {
    StringBuilder hour=new StringBuilder(),minute=new StringBuilder();
    String anshour="0";
    String ansminute="0";
    int[] vis=new int[4];
    public String largestTimeFromDigits(int[] A) {
        if(A[0]==A[1]&&A[1]==A[2]&&A[2]==A[3]&&A[3]==0)
            return "00:00";
        dfs(A,0);
        return (anshour.equals("0")&&anshour.equals("0")?"":anshour+":"+ansminute);
    }

    public void dfs(int[] nums,int count) {
        if(count==4){
            if(Integer.parseInt(hour.toString()) >= 24 || Integer.parseInt(minute.toString())>=60)
                return;
            else{
                if(Integer.parseInt(hour.toString()) > Integer.parseInt(anshour.toString())){
                    anshour=new String(hour.toString());
                    ansminute=new String(minute.toString());
                }
                else if(Integer.parseInt(hour.toString())==Integer.parseInt(anshour.toString())){
                    if(Integer.parseInt(minute.toString()) > Integer.parseInt(ansminute.toString())){
                        anshour=new String(hour.toString());
                        ansminute=new String(minute.toString());
                    }
                }
                return;
            }
        }
        for(int i=0;i<4;i++){
            if(vis[i]==0){
                if(count<2){
                    hour.append(nums[i]);
                    vis[i]=1;
                    dfs(nums,count+1);
                    vis[i]=0;
                    hour.deleteCharAt(hour.length()-1);
                }
                else{
                    minute.append(nums[i]);
                    vis[i]=1;
                    dfs(nums,count+1);
                    vis[i]=0;
                    minute.deleteCharAt(minute.length()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Largest_Time_for_Given_Digits test=new Largest_Time_for_Given_Digits();
        int[]nums={1,2,3,4};
        System.out.println(test.largestTimeFromDigits(nums));
    }
}
