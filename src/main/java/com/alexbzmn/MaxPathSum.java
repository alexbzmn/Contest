package com.alexbzmn;

import com.alexbzmn.util.GraphBuilder;
import com.alexbzmn.util.Node;

public class MaxPathSum {
    public static void main(String[] args) {

        GraphBuilder graphBuilder = new GraphBuilder();
        graphBuilder.addEdge(10, 2);
        graphBuilder.addEdge(10, 11);
        graphBuilder.addEdge(2, 20);
        graphBuilder.addEdge(2, 1);
        graphBuilder.addEdge(11, -25);
        graphBuilder.addEdge(-25, 3);
        graphBuilder.addEdge(-25, 4);

        Node node = new Node();
        node.val = Integer.MIN_VALUE;
        findMaxPathSum(graphBuilder.getNode(10), node);

        System.out.println(node.val);

    }

    private static int findMaxPathSum(Node node, Node globalMax) {

        int sumItself = node.val;
        int sumLeft = 0;
        int sumRight = 0;

        if (node.edges.size() > 0) {
            sumLeft = findMaxPathSum(node.edges.get(0), globalMax);

            if (node.edges.size() > 1) {
                sumRight = findMaxPathSum(node.edges.get(1), globalMax);
            }
        }

        int localMax = Math.max(Math.max(sumLeft, sumRight) + sumItself, sumItself);


        globalMax.val = Math.max(localMax, sumItself + sumLeft + sumRight);
        return localMax;
    }
}
