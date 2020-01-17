package com.alexbzmn;

public class Atoi {

    public static void main(String[] args) {
//        System.out.println(new Atoi().myAtoi("   -42"));
//        System.out.println(new Atoi().myAtoi("-91283472332"));
        System.out.println(new Atoi().myAtoi("-2147483647"));
    }

    public int myAtoi(String str) {
        // skip empty spaces
        // check for optional sign
        // check if the first sequence is an integral number
        // take the first seq and apply the sign

        if (str.isEmpty()) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();

        boolean isPositive = true;
        boolean seqIsStarted = false;
        boolean signSet = false;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' && !seqIsStarted) {
                continue;
            }

            if ((chars[i] == '-' || chars[i] == '+') && !signSet && !seqIsStarted && i < chars.length - 1 &&
                    Character.isDigit(chars[i + 1])) {
                if (chars[i] == '-') {
                    isPositive = false;
                }

                signSet = true;
                continue;
            }

            if (!Character.isDigit(chars[i]) && sb.length() > 0) {
                break;
            }

            if (!Character.isDigit(chars[i]) && !seqIsStarted) {
                return 0;
            }

            if (Character.isDigit(chars[i])) {
                seqIsStarted = true;

                if (chars[i] != '0' || sb.length() > 0) {
                    sb.append(chars[i]);
                }

                continue;
            }

            break;
        }

        if (sb.length() == 0) {
            return 0;
        }
        if (sb.length() > 10) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        long result = Long.parseLong(sb.toString());
        if (isPositive && result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (!isPositive && -result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }


        return isPositive ? (int) result : (int) -result;
    }

}
