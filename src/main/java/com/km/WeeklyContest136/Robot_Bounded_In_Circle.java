package com.km.WeeklyContest136;

public class Robot_Bounded_In_Circle {
    public boolean isRobotBounded(String instructions) {
        int curx = 0, cury = 0;
        int dire = 0;  //0向北，1向东，2向南，3向西
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                if (instructions.charAt(j) == 'G') {
                    if (dire == 0)
                        curx++;
                    else if (dire == 1)
                        cury++;
                    else if (dire == 2)
                        curx--;
                    else
                        cury--;
                } else if (instructions.charAt(j) == 'L')
                    dire = (dire + 1) % 4;
                else
                    dire = (dire + 3) % 4;
            }
            if (curx == 0 && cury == 0)
                return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Robot_Bounded_In_Circle test = new Robot_Bounded_In_Circle();
        System.out.println(test.isRobotBounded("GGLLGG"));
    }
}
