package com.alexbzmn;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by User on 7/11/2017.
 */
public class TwoCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();

        String[] a = s.split("");
        Map<String, Integer> occ = new HashMap<>();

        for (String el : a) {
            if (!occ.containsKey(el)) {
                occ.put(el, 1);
            } else {
                occ.put(el, occ.get(el) + 1);
            }
        }

        AbstractMap.SimpleEntry<String, Integer> firstEntry = new AbstractMap.SimpleEntry<>("", 0);
        AbstractMap.SimpleEntry<String, Integer> secondEntry = new AbstractMap.SimpleEntry<>("", 0);


        for (Map.Entry<String, Integer> entry : occ.entrySet()) {
            if (entry.getValue() > firstEntry.getValue()) {
                secondEntry = firstEntry;
                firstEntry = new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue());
            } else if (entry.getValue() > secondEntry.getValue()) {
                secondEntry = new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue());
            }
        }

        if (occ.size() < 2) {
            System.out.println(0);
        } else {

            int letterCount = 0;
            for (String el : a) {
                if (el.equals(firstEntry.getKey()) || el.equals(secondEntry.getKey())) {
                    letterCount++;
                }
            }

            System.out.println(letterCount);

        }
    }
}
