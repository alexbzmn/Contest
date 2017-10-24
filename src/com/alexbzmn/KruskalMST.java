package com.alexbzmn;

import com.alexbzmn.ds.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalMST {
    public static void main(String[] args) {
        int e = 7;
        int v = 5;

        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }

        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = -1;
        }

        edges[0].src = 0;
        edges[0].dest = 1;
        edges[0].cost = 3;

        edges[1].src = 1;
        edges[1].dest = 2;
        edges[1].cost = 5;

        edges[2].src = 2;
        edges[2].dest = 3;
        edges[2].cost = 2;

        edges[3].src = 3;
        edges[3].dest = 4;
        edges[3].cost = 7;

        edges[4].src = 4;
        edges[4].dest = 0;
        edges[4].cost = 1;

        edges[5].src = 4;
        edges[5].dest = 2;
        edges[5].cost = 6;

        edges[6].src = 4;
        edges[6].dest = 1;
        edges[6].cost = 4;


        System.out.println(Arrays.toString(kruskalMST(edges, v)));
    }

    private static Edge[] kruskalMST(Edge[] edges, int n) {
        Arrays.sort(edges);

        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            Edge[] testMst = mst.toArray(new Edge[mst.size() + 1]);
            testMst[mst.size()] = edge;

            if (!UnionFind.containsCycle(testMst, n)) {
                mst.add(edge);
            }
        }

        return mst.toArray(new Edge[mst.size()]);
    }
}
