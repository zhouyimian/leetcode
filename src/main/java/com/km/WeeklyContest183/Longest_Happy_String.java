package com.km.WeeklyContest183;

public class Longest_Happy_String {
    private String generate(int a, int b, int c, String aa, String bb, String cc) {
        if (a < b)
            return generate(b, a, c, bb, aa, cc);
        if (a < c)
            return generate(c, b, a, cc, bb, aa);
        if (b < c)
            return generate(a, c, b, aa, cc, bb);
        if (b == 0) {
            String res = "";
            for(int i = 0;i< Math.min(2,a);i++)
                res+=aa;
            return res;
        };
        int use_a = Math.min(2, a), use_b = a - use_a >= b ? 1 : 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<use_a;i++)
            res.append(aa);
        for(int i = 0;i<use_b;i++)
            res.append(bb);
        return res.toString() +
                generate(a - use_a, b - use_b, c, aa, bb, cc);
    }
    public String longestDiverseString(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }

    public static void main(String[] args) {
        Longest_Happy_String test = new Longest_Happy_String();
        System.out.println(test.longestDiverseString(20, 4, 1));
    }
}
