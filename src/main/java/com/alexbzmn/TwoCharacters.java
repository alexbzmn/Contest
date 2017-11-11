package com.alexbzmn;

import java.util.*;

/**
 * Created by User on 7/11/2017.
 */
//TODO
public class TwoCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        System.out.println(count(s));
    }

    private static int count(String s) {
        Map<String, Integer> maxCombinations = new HashMap<>();

        String[] sArr = s.split("");
        Set<String> letters = new HashSet<>(Arrays.asList(sArr));

        for (String a : letters) {
            for (String b : letters) {
                if (b.equals(a)
                        || maxCombinations.containsKey(b + a)
                        || maxCombinations.containsKey(a + b)) {
                    continue;
                }

                int count = 0;
                boolean isValid = true;

                String prev = "";
                for (String l : sArr) {
                    if (!l.equals(a) && !l.equals(b)) {
                        continue;
                    }

                    if (l.equals(prev)) {
                        isValid = false;
                        break;
                    } else {
                        prev = l;
                        count++;
                    }
                }

                if (isValid) {
                    maxCombinations.put(a + b, count);
                }

            }
        }


        Integer max = 0;
        for (Integer x : maxCombinations.values()) {
            if (x > max) {
                max = x;
            }
        }

        return max;
    }
}
