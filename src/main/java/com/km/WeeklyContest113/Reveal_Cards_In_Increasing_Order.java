package com.km.WeeklyContest113;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Reveal_Cards_In_Increasing_Order {
    class N{
        public int index;
        public int val;

        public N(N first) {
            this.val=first.val;
            this.index=first.index;
        }
        public N(){}
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<N> queue=new ArrayDeque<N>();
        Deque<N> ans=new ArrayDeque<N>();
        for(int i=0;i<deck.length;i++) {
            N num = new N();
            num.index = i;
            num.val = deck[i];
            N queuenum=new N();
            queuenum.index=i;
            queue.addLast(queuenum);
        }
        for(int i=0;i<deck.length;i++){
            N num=new N(queue.getFirst());
            num.val=deck[i];
            ans.addLast(num);
            if(ans.size()==deck.length)
                break;
            queue.removeFirst();
            N temp=new N(queue.getFirst());
            queue.addLast(temp);
            queue.removeFirst();
        }
        int[] ansdeck=new int[deck.length];
        for(int i=0;i<deck.length;i++){
            N n=ans.getFirst();
            ans.removeFirst();
            ansdeck[n.index]=n.val;
        }
        return ansdeck;
    }

    public static void main(String[] args) {
        Reveal_Cards_In_Increasing_Order test=new Reveal_Cards_In_Increasing_Order();
        int[] nums={2,13,3,11,5,17,7};
        for(int num:test.deckRevealedIncreasing(nums)){
            System.out.println(num);
        }
    }
}
