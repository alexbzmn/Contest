package com.alexbzmn;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {

        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                new char[]{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                new char[]{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                new char[]{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                new char[]{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                new char[]{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                new char[]{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '4', '.', '.', '.', '.', '.', '.'},
        }));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> block = new HashSet<>();
        Set<String> v = new HashSet<>();
        Set<String> h = new HashSet<>();

        int k = 0;
        int l = 0;

        int ch = 0;
        int cv = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[i][j] != '.') {
                    String blockKey = "" + ch + "" + cv + board[i][j];
                    String vKey = "" + j + "" + board[i][j];
                    String hKey = "" + i + "" + board[i][j];
                    if (block.contains(blockKey) || v.contains(vKey) || h.contains(hKey)) {
                        return false;
                    }

                    block.add(blockKey);
                    v.add(vKey);
                    h.add(hKey);
                }

                if (l == 2) {
                    ch++;
                    l = 0;
                } else {
                    l++;
                }
            }

            ch = 0;

            if (k == 2) {
                cv++;
                k = 0;
            } else {
                k++;
            }
        }

        return true;
    }
}
