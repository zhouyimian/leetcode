package com.km.WeeklyContest142;

public class Statistics_from_a_Large_Sample {
    public double[] sampleStats(int[] count) {

        double[] ans = new double[5];
        double min = 0,max = 0,mean = 0,median = 0,mode = 0,maxTime = 0,maxIndex = 0;
        for(int i = 0;i<=255;i++){
            if(count[i]!=0){
                min = i+0.0;
                break;
            }
        }
        for(int i = 255;i>=0;i--){
            if(count[i]!=0){
                max = i+0.0;
                break;
            }
        }
        double nums_count = 0;
        double sum_count = 0;
        for(int i = 0;i<=255;i++){
            nums_count+=count[i];
            sum_count+=count[i]*i*1.0;
            if(count[i]>=maxTime){
                maxTime = count[i];
                maxIndex = i;
            }
        }
        mean = sum_count/nums_count;
        int cur_count = 0;
        for(int i = 0;i<=255;i++){
            if(count[i]!=0){
                cur_count+=count[i];
                if(nums_count%2==0){
                    if(cur_count==nums_count/2){
                        median = (i+next(i,count))/2.0;
                        break;
                    }else if(cur_count>nums_count/2){
                        median = i;
                        break;
                    }
                }else{
                    if(cur_count>=nums_count/2) {
                        median = i;
                        break;
                    }
                }
            }
        }

        ans[0] = min;
        ans[1] = max;
        ans[2] = mean;
        ans[3] = median;
        ans[4] = maxIndex;
        return ans;
    }

    private int next(int cur, int[] count) {
        for(int i = cur+1;i<=255;i++){
            if(count[i]!=0)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Statistics_from_a_Large_Sample test = new Statistics_from_a_Large_Sample();
        double[]ans = test.sampleStats(nums);
        for(double num:ans)
            System.out.println(num);
    }
}
//{0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
