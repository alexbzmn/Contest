package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {
        int n = 30;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'a';
            }
        }

        board[n - 1][n - 1] = 'b';

        StringBuilder sb = new StringBuilder();
        sb.append('b');
        for (int i = 0; i < (n * n) - 1; i++) {
            sb.append('a');
        }
        System.out.println(new WordSearch().exist(board, sb.toString()));
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || (board.length * board[0].length) < word.length()) {
            return false;
        }

        Set<String> first = new HashSet<>();
        char f = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == f) {
                    first.add(i + "" + j);
                }
            }
        }

        List<Character> w = new ArrayList<>();
        for (char c : word.toCharArray()) {
            w.add(c);
        }
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (String pair : first) {
            boolean res = find(Integer.parseInt(pair.substring(0, pair.length() / 2)), Integer.parseInt(pair.substring(pair.length() / 2)), board, w, 0, seen);
            if (res) {
                return true;
            }
        }

        return false;
    }

    private boolean find(int i, int j, char[][] b, List<Character> w, int l, boolean[][] seen) {
        if (l > w.size() - 1) {
            return true;
        }

        if (i < 0 || j < 0 || i > b.length - 1 || j > b[0].length - 1) {
            return false;
        }

        if (!seen[i][j] && b[i][j] == w.get(l)) {
            seen[i][j] = true;
            boolean result =
                    find(i + 1, j, b, w, l + 1, seen) ||
                            find(i - 1, j, b, w, l + 1, seen) ||
                            find(i, j + 1, b, w, l + 1, seen) ||
                            find(i, j - 1, b, w, l + 1, seen);
            if (!result) {
                seen[i][j] = false;
            }
            return result;
        }

        return false;
    }
}
