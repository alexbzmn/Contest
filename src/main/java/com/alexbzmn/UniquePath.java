package com.alexbzmn;

public class UniquePath {
    public static void main(String[] args) {
        int result = new UniquePath().uniquePaths(3, 2);
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {

        if (n < 1 || m < 1) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }
        int h = uniquePaths(m - 1, n);
        int v = uniquePaths(m, n - 1);

        return h + v;
    }
}
