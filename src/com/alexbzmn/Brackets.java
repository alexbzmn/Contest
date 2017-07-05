package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by User on 7/5/2017.
 */
public class Brackets {

    public static boolean isBalanced(String expression) {
        String[] brackets = expression.split("");
        Stack<String> brStack = new Stack<>();

        Map<String, String> mapping = new HashMap<>();
        mapping.put("}", "{");
        mapping.put(")", "(");
        mapping.put("]", "[");

        for (String el : brackets) {
            if (el.equals("{") || el.equals("(") || el.equals("[")) {
                brStack.push(el);
            } else {

                if (brStack.isEmpty()) {
                    return false;
                }

                if (!brStack.peek().equals(mapping.get(el))) {
                    return false;
                } else {
                    brStack.pop();
                }
            }
        }

        return brStack.isEmpty();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
