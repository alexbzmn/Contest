package com.alexbzmn;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KruskalMST2 {
    static class Edge implements Comparable<Edge> {
        int src;
        int dst;
        Integer cst;

        public int compareTo(Edge o) {
            return cst.compareTo(o.cst);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            Edge e = new Edge();
            e.src = sc.nextInt();
            e.dst = sc.nextInt();
            e.cst = sc.nextInt();
            edges[i] = e;
        }

        Arrays.sort(edges);

        int finalCost = unionFind(Arrays.asList(edges), parent);
        System.out.println(finalCost);
    }

    private static int unionFind(List<Edge> edges, int[] parent) {
        int sum = 0;

        for (Edge edge : edges) {
            int x = edge.src;
            int y = edge.dst;

            if (find(x - 1, parent) != find(y - 1, parent)) {
                if (!isTargetReferenced(y - 1, parent)) {
                    parent[x - 1] = y - 1;
                    sum += edge.cst;
                }

            }
        }
        return sum;
    }

    private static boolean isTargetReferenced(int x, int[] parent) {
        for (int i : parent) {
            if (i == x) {
                return true;
            }
        }

        return false;
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == -1) {
            return x;
        } else {
            return find(parent[x], parent);
        }
    }
}
