package com.km;


import java.util.Scanner;

public class Main {
    static class BigIntAdd {
        private int[] array;
        public static String bigAdd(BigIntAdd fisrtNum, BigIntAdd secondNum) {
            String result = "";
            boolean falg = false;
            int[] firstarray;
            int[] secondarray;
            int[] thirdarray = null;
            if (fisrtNum.instance().length >= secondNum.instance().length) {
                firstarray = fisrtNum.instance();
                secondarray = secondNum.instance();
            } else {
                firstarray = secondNum.instance();
                secondarray = fisrtNum.instance();
            }

            for (int i = 0; i < secondarray.length; i++) {
                if (firstarray[i] + secondarray[i] < 10) {
                    firstarray[i] = firstarray[i] + secondarray[i];
                } else if (firstarray[i] + secondarray[i] >= 10) {
                    firstarray[i] = firstarray[i] + secondarray[i] - 10;

                    if ((i + 1) < firstarray.length) {
                        firstarray[i + 1] = firstarray[i + 1] + 1;
                    } else {
                        falg = true;
                        thirdarray = new int[firstarray.length + 1];
                        System.arraycopy(firstarray, 0, thirdarray, 0, firstarray.length);
                        thirdarray[firstarray.length] = 1;
                    }
                }
            }
            if (falg) {
                for (int i : thirdarray) {
                    result += i;
                }
            } else {
                for (int i : firstarray) {
                    result += i;
                }
            }
            return new StringBuffer(result).reverse().toString();
        }
        private int[] instance() {
            return array;
        }
        public BigIntAdd(String num) {
            StringBuffer sb = new StringBuffer(num);
            String string = sb.reverse().toString();
            array = new int[string.length()];
            for (int i = 0; i < string.length(); i++) {
                array[i] = Integer.valueOf(string.substring(i, i + 1));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String result = BigIntAdd.bigAdd(new BigIntAdd(s1), new BigIntAdd(s2));
        System.out.println(result);
    }
}
