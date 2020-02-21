package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || (board.length * board[0].length) < word.length()) {
            return false;
        }

        List<Integer> v = new ArrayList<>();
        List<Integer> h = new ArrayList<>();

        char f = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == f) {
                    v.add(i);
                    h.add(j);
                }
            }
        }

        List<Character> w = new ArrayList<>();
        for (char c : word.toCharArray()) {
            w.add(c);
        }

        for (int i = 0; i < v.size(); i++) {
            Set<String> seen = new HashSet<>();
            boolean res = find(v.get(i), h.get(i), board, w, 0, seen);
            if (res) {
                return true;
            }
        }

        return false;
    }

    private boolean find(int i, int j, char[][] b, List<Character> w, int l, Set<String> seen) {
        if (l > w.size() - 1) {
            return true;
        }

        if (i < 0 || j < 0 || i > b.length - 1 || j > b[0].length - 1) {
            return false;
        }

        String key = i + "" + j;
        if (!seen.contains(key) && b[i][j] == w.get(l)) {
            seen.add(key);
            boolean result =
                    find(i + 1, j, b, w, l + 1, seen) ||
                            find(i - 1, j, b, w, l + 1, seen) ||
                            find(i, j + 1, b, w, l + 1, seen) ||
                            find(i, j - 1, b, w, l + 1, seen);
            if (!result) {
                seen.remove(key);
            }
            return result;
        }

        return false;
    }

}
