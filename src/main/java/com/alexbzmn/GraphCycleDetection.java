package com.alexbzmn;

import com.alexbzmn.util.GraphBuilder;
import com.alexbzmn.util.Node;

import java.util.Stack;

public class GraphCycleDetection {


    private static boolean hasCycle(Node root) {
        Stack<Integer> recStack = new Stack<>();
        return hasCycle(root, recStack);
    }

    private static boolean hasCycle(Node root, Stack<Integer> stack) {
        if (stack.contains(root.val)) {
            return true;
        } else {
            stack.add(root.val);
            for (Node child : root.edges) {
                boolean childHasCycle = hasCycle(child, stack);
                if (childHasCycle) {
                    return true;
                }
            }

            stack.pop();
        }

        return false;
    }

    public static void main(String[] args) {
        GraphBuilder graphBuilder = new GraphBuilder();
        graphBuilder.addEdge(0, 1);
        graphBuilder.addEdge(0, 2);
        graphBuilder.addEdge(1, 2);
        graphBuilder.addEdge(2, 0);
        graphBuilder.addEdge(2, 3);
        graphBuilder.addEdge(3, 3);

        System.out.println(hasCycle(graphBuilder.getNode(2)));
    }


}
