package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 7/10/2017.
 */
public class ListAnagrams {
    public static void main(String[] args) {
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();

        listOne.add("supertest");
        listOne.add("samplematch");

        listTwo.add("pee");
        listTwo.add("rees");
        listTwo.add("puer");
        listTwo.add("puero");
        listTwo.add("pleats");
        listTwo.add("chelas");
        listTwo.add("athame");

        for (String s : listTwo) {
            boolean isAnagram = false;
            for (String s1 : listOne) {
                if (isAnagram(s1, s)) {
                    isAnagram = true;
                    break;
                }
            }

            System.out.println(s + (isAnagram ? " YES" : " NO"));

        }

    }

    private static boolean isAnagram(String wordOne, String wordTwo) {
        List<String> lettersOne = new ArrayList<>(Arrays.asList(wordOne.split("")));
        List<String> lettersTwo = Arrays.asList(wordTwo.split(""));

        for (String s : lettersTwo) {
            if (lettersOne.contains(s)) {
                lettersOne.remove(s);
            } else {
                return false;
            }
        }

        return true;
    }
}
