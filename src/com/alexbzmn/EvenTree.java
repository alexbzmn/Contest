package com.alexbzmn;

import com.alexbzmn.util.GraphBuilder;
import com.alexbzmn.util.Node;

import java.util.Scanner;

public class EvenTree {
    /*
        https://www.hackerrank.com/challenges/even-tree
        You are given a tree (a simple connected graph with no cycles). The tree has  nodes numbered from  to  and is rooted at node .

        Find the maximum number of edges you can remove from the tree to get a forest such that each connected component of the forest contains an even number of nodes.

        Input Format
        The first line of input contains two integers  and .  is the number of nodes, and  is the number of edges.
        The next  lines contain two integers  and  which specifies an edge of the tree.

        Constraints
        Note: The tree in the input will be such that it can always be decomposed into components containing an even number of nodes.

        Output Format
        Print the number of removed edges.

        Sample Input
        10 9
        2 1
        3 1
        4 3
        5 2
        6 1
        7 2
        8 6
        9 8
        10 8
        Sample Output
        2
     */

    private static int cutCount = 0;

    private static int countChildren(Node parent) {
        int chCount = 1;

        for (Node child : parent.edges) {
            chCount += countChildren(child);
        }

        if (chCount % 2 == 0 && parent.key != 1) {
            cutCount++;
            return 0;
        }

        return chCount;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        GraphBuilder gb = new GraphBuilder();

        for (int i = 0; i < m; i++) {
            int finish = sc.nextInt();
            int start = sc.nextInt();

            gb.addEdge(start, finish);
        }

        Node root = gb.getNode(1);

        countChildren(root);

        System.out.println(cutCount);

    }
}
