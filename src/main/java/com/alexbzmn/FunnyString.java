package com.alexbzmn;

import java.util.Scanner;

/**
 * Created by User on 7/12/2017.
 */

public class FunnyString {
    static String funnyString(String s){

        char[] charArray = s.toCharArray();

        if (charArray.length == 2) {
            if (Math.abs(charArray[0]) == Math.abs(charArray[1])) {
                return "Funny";
            } else {
                return "Not Funny";
            }
        }


        int middleIndex = (charArray.length / 2) - 1;
        int i = middleIndex;
        int k = middleIndex + 1;
        if (charArray.length % 2 != 0) {
            k++;
        }

        while (i < charArray.length - 1 && k > 0) {
            int sumLeft = Math.abs(Math.abs(charArray[i]) - Math.abs(charArray[i-1]));
            int sumRight = Math.abs(Math.abs(charArray[k]) - Math.abs(charArray[k + 1]));

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
