package com.km.WeeklyContest116;

public class Minimum_Area_Rectangle_II {
    public double minAreaFreeRect(int[][] points) {
        double ans=Double.MAX_VALUE;
        int len=points.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int m=j+1;m<len;m++){
                    for(int n=m+1;n<len;n++){
                        ans=Math.min(ans,deal(points,i,j,m,n));
                    }
                }
            }
        }
        return ans==Double.MAX_VALUE?0:ans;
    }

    private double deal(int[][] points, int i, int j, int m, int n) {
        int[][] nums=new int[4][2];
        nums[0][0]=points[i][0];nums[0][1]=points[i][1];
        nums[1][0]=points[j][0];nums[1][1]=points[j][1];
        nums[2][0]=points[m][0];nums[2][1]=points[m][1];
        nums[3][0]=points[n][0];nums[3][1]=points[n][1];
        for(int k=0;k<4;k++){
            for(int start=0;start<3;start++)
                if(nums[start][0]>nums[start+1][0]||(nums[start][0]==nums[start+1][0]&&nums[start][1]>nums[start+1][1])){
                    exchange(nums,start,start+1);
                }
        }
        double len1=Math.sqrt((nums[0][0]-nums[1][0])*(nums[0][0]-nums[1][0])+(nums[0][1]-nums[1][1])*(nums[0][1]-nums[1][1]));
        double len2=Math.sqrt((nums[0][0]-nums[2][0])*(nums[0][0]-nums[2][0])+(nums[0][1]-nums[2][1])*(nums[0][1]-nums[2][1]));
        double len3=Math.sqrt((nums[1][0]-nums[3][0])*(nums[1][0]-nums[3][0])+(nums[1][1]-nums[3][1])*(nums[1][1]-nums[3][1]));
        double len4=Math.sqrt((nums[2][0]-nums[3][0])*(nums[2][0]-nums[3][0])+(nums[2][1]-nums[3][1])*(nums[2][1]-nums[3][1]));
        double len5=Math.sqrt((nums[1][0]-nums[2][0])*(nums[1][0]-nums[2][0])+(nums[1][1]-nums[2][1])*(nums[1][1]-nums[2][1]));
        double len6=Math.sqrt((nums[0][0]-nums[3][0])*(nums[0][0]-nums[3][0])+(nums[0][1]-nums[3][1])*(nums[0][1]-nums[3][1]));
        double dis=1e-6;
        if(Math.abs(len1*len1+len2*len2-len5*len5)>dis)
            return Double.MAX_VALUE;
        if(Math.abs(len3*len3+len4*len4-len5*len5)>dis)
            return Double.MAX_VALUE;
        if(Math.abs(len1*len1+len3*len3-len6*len6)>dis)
            return Double.MAX_VALUE;
        if(Math.abs(len2*len2+len4*len4-len6*len6)>dis)
            return Double.MAX_VALUE;
        return len1*len3;
    }

    private void exchange(int[][] nums, int k, int i) {
        int temp;
        temp=nums[k][0];nums[k][0]=nums[i][0];nums[i][0]=temp;
        temp=nums[k][1];nums[k][1]=nums[i][1];nums[i][1]=temp;
    }

    public static void main(String[] args) {
        int[][] nums={{0,3},{1,2},{3,1},{1,3},{2,1}};
        Minimum_Area_Rectangle_II test=new Minimum_Area_Rectangle_II();
        System.out.println(test.minAreaFreeRect(nums));
    }

}
