package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 7/5/2017.
 */
public class Anagrams {
    public static int numberNeeded(String first, String second) {

        List<String> listFirst = new ArrayList<String>();
        List<String> listSecond = new ArrayList<String>();

        listFirst.addAll(Arrays.asList(first.split("")));
        listSecond.addAll(Arrays.asList(second.split("")));

        List<String> dups = new ArrayList<>();

        for (String el : listFirst) {
            if (listSecond.contains(el)) {
                dups.add(el);
                listSecond.remove(el);
            }
        }

        for (String dup : dups) {
            listFirst.remove(dup);
        }

        return listFirst.size() + listSecond.size();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
