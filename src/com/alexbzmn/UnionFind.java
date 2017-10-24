package com.alexbzmn;

import com.alexbzmn.ds.Edge;

public class UnionFind {
    public static void main(String[] args) {
        int e = 3;
        int v = 3;

        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }

        edges[0].src = 0;
        edges[0].dest = 1;

        // add edge 1-2
        edges[1].src = 1;
        edges[1].dest = 2;

        // add edge 0-2
        edges[2].src = 0;
        edges[2].dest = 2;

        System.out.println(containsCycle(edges, v));
    }

    public static boolean containsCycle(Edge[] edges, int n) {

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        for (Edge edge : edges) {
            if (find(edge.src, parent) == find(edge.dest, parent)) {
                return true;
            } else {
                union(edge.src, edge.dest, parent);
            }

        }

        return false;

    }

    private static void union(int x, int y, int[] parent) {
        parent[x] = y;
    }

    private static int find(int x, int[] parent) {

        if (parent[x] == -1) {
            return x;
        } else {
            return find(parent[x], parent);
        }

    }


}

