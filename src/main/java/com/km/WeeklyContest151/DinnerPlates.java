package com.km.WeeklyContest151;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DinnerPlates {
    List<Stack<Integer>> list ;
    int capacity;
    int kongque;

    public DinnerPlates(int capacity) {
        this.list = new ArrayList<>();
        this.capacity = capacity;
        this.kongque = -1;
    }

    public void push(int val) {
        if(kongque!=-1&&list.get(kongque).size()<capacity){
            list.get(kongque).push(val);
            return;
        }else{
            kongque = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() < capacity) {
                list.get(i).push(val);
                return;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(val);
        list.add(stack);
    }

    public int pop() {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).isEmpty()) {
                list.remove(i);
            } else {
                kongque = kongque == -1 ? i : Math.min(kongque,i);
                return list.get(i).pop();
            }
        }
        return -1;
    }

    public int popAtStack(int index) {
        if (list.get(index).isEmpty())
            return -1;
        else {
            kongque = kongque == -1 ? index : kongque <= index ? kongque : index;
            return list.get(index).pop();
        }
    }

    public static void main(String[] args) {
        DinnerPlates d = new DinnerPlates(2);
        d.push(1);
        d.push(2);
        d.push(3);
        d.push(4);

    }
}
