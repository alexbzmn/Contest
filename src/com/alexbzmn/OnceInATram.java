package com.alexbzmn;

import java.util.Scanner;

/**
 * @author Aleksei Batcman <aleksei.batcman@wirecard.com>
 * @since 17.07.2017
 */
public class OnceInATram {
    static String onceInATram(int x) {
        String s = String.valueOf(x);
        String[] arr = s.split("");

        int[] a = new int[arr.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(arr[i]);
        }

        int sumOne = a[0] + a[1] + a[2];
        int sumTwo = a[3] + a[4] + a[5];

        if (sumOne == sumTwo) {
            int deltaI = a.length - 1;

            for (int i = a.length - 1; i >= 3; i--) {
                if (a[i] > 0) {
                    a[i] = a[i]--;
                    deltaI = i;
                    break;
                }
            }

            for (int i = a.length - 1; i >= 3; i--) {
                if (i != deltaI) {
                    if (a[i] < 9) {
                        a[i] = a[i]++;
                        break;
                    }
                }
            }

        } else if (sumOne > sumTwo) {
            int diff = sumOne - sumTwo;
            while (sumOne > sumTwo) {

                while (a[5] < 9) {
                    if (diff > 0) {
                        a[5] = a[5] + 1;
                        diff--;
                    } else {
                        break;
                    }
                }

                while (a[4] < 9) {
                    if (diff > 0) {
                        a[4] = a[4] + 1;
                        diff--;
                    } else {
                        break;
                    }
                }

                while (a[3] < 9) {
                    if (diff > 0) {
                        a[3] = a[3] + 1;
                        diff--;
                    } else {
                        break;
                    }
                }

                sumTwo = a[3] + a[4] + a[5];
            }
        } else if (sumTwo > sumOne) {
            int diff = sumTwo - sumOne;
            while (sumTwo > sumOne) {

                while (a[2] < 9) {
                    if (diff > 0) {
                        a[2] = a[2] + 1;
                        diff--;
                    } else {
                        break;
                    }
                }

                while (a[1] < 9) {
                    if (diff > 0) {
                        a[1] = a[1] + 1;
                        diff--;
                    } else {
                        break;
                    }
                }

                while (a[0] < 9) {
                    if (diff > 0) {
                        a[0] = a[0] + 1;
                        diff--;
                    } else {
                        break;
                    }
                }

                sumOne = a[0] + a[1] + a[2];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int el : a) {
            sb.append(el);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String result = onceInATram(x);
        System.out.println(result);
    }
}
