package com.alexbzmn;

import java.util.Scanner;

/**
 * Created by User on 7/12/2017.
 */

//TODO
public class FunnyString {
    static String funnyString(String s) {


        char[] charArray = s.toCharArray();

        if (charArray.length == 2) {
            if (Math.abs(charArray[0] - charArray[1]) == 0) {
                return "Funny";
            } else {
                return "Not Funny";
            }
        }


        int middleIndex = (charArray.length / 2) - 1;
        int i = middleIndex;
        int k = middleIndex + 1;

        while (i < charArray.length - 1 && k > 0) {
            int sumLeft = Math.abs(charArray[i] - charArray[i - 1]);
            int sumRight = Math.abs(charArray[k] - charArray[k + 1]);

            if (sumLeft != sumRight) {
                return "Not Funny";
            }

            k--;
            i++;
        }

        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}
