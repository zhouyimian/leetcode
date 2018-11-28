package com.km.WeeklyContest89;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExamRoom {
	int length;
	Set<Integer> seats;

	public ExamRoom(int N) {
		length = N-1;
		seats = new TreeSet<>();
	}

	public int seat() {
		if (seats.size() == 0) {
			seats.add(0);
			return 0;
		} else {
			List<Integer> temp_list = new ArrayList<>(seats);
			int distinct = 0;
			int position = 0;
			if (temp_list.get(0) != 0) {
				distinct = temp_list.get(0);
				position = 0;
			}
			if (temp_list.get(temp_list.size() - 1) != length) {
				if (distinct < length - temp_list.get(temp_list.size() - 1)) {
					distinct = length - temp_list.get(temp_list.size() - 1);
					position = length;
				}
			}
			if(seats.size()==2) {
				if (distinct < ((temp_list.get(1)-temp_list.get(0))>>1)) {
					distinct = (temp_list.get(1)-temp_list.get(0))>>1;
					position = (temp_list.get(1)+temp_list.get(0))>>1;
				}	
			}
			for (int i = 1; i < temp_list.size() - 1; i++) {
				int before = temp_list.get(i - 1);
				int after = temp_list.get(i + 1);
				int now = temp_list.get(i);
				if ((after - now) >> 1 == (now - before) >> 1&&distinct<(now - before) >> 1) {
					distinct = (now - before) >> 1;
					position = (now + before) >> 1;
				}
				else if ((after - now) >> 1 > (now - before) >> 1&&distinct<(after - now) >> 1) {
					distinct = (after - now)>> 1;
					position = (after + now) >> 1;
				}
				else if((after - now) >> 1 <(now - before) >> 1&&distinct<(now - before) >> 1){
					distinct = (now - before) >> 1;
					position = (now + before) >> 1;
				}
			}
			seats.add(position);
			return position;
		}
	}

	public void leave(int p) {
		seats.remove(p);
	}
	public static void main(String[] args) {
		ExamRoom e=new ExamRoom(10);
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		e.leave(0);
		e.leave(4);
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		e.leave(0);
	}
}
