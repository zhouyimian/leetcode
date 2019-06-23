package com.km.WeeklyContest142;

public class Find_in_Mountain_Array {
    class MountainArray {
        public int get(int index) {
            return 0;
        }

        public int length() {
            return 0;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0;
        int high = mountainArr.length()-1;
        int top = -1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                top = low = mid+1;
            }else{
                high = mid;
            }
        }
        low = 0;
        high = top;
        while(low<=high){
            int mid = low + (high-low)/2;
            int num = mountainArr.get(mid);
            if(num<target)
                low = mid+1;
            else if(num>target)
                high = mid-1;
            else
                return mid;
        }
        low = top;
        high = mountainArr.length()-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int num = mountainArr.get(mid);
            if(num>target)
                low = mid+1;
            else if(num<target)
                high = mid-1;
            else
                return mid;
        }
        return -1;
    }
}
