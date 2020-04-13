package com.alexbzmn;

import com.alexbzmn.util.GraphBuilder;
import com.alexbzmn.util.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    private static void topSort(List<Node> graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (Node node : graph) {
            if (!visited.contains(node.val)) {
                topSort(node, stack, visited);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void topSort(Node root, Stack<Integer> stack, Set<Integer> visited) {
        visited.add(root.val);

        for (Node child : root.edges) {
            if (!visited.contains(child.val)) {
                topSort(child, stack, visited);
            }
        }

        stack.push(root.val);
    }

    public static void main(String[] args) {
        GraphBuilder g = new GraphBuilder();
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        topSort(g.graph);

    }
}
