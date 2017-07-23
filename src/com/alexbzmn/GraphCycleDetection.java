package com.alexbzmn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphCycleDetection {

    private static class GraphBuilder {
        List<Node> graph = new LinkedList<>();

        private void addEdge(Integer start, Integer finish) {
            Node startNode = null;
            Node finishNode = null;

            for (Node v : graph) {
                if (v.key.equals(start)) {
                    startNode = v;
                }
                if (v.key.equals(finish)) {
                    finishNode = v;
                }
            }

            if (startNode == null) {
                startNode = new Node();
                startNode.key = start;
                graph.add(startNode);
            }

            if (finishNode == null) {
                finishNode = new Node();
                finishNode.key = finish;
                graph.add(finishNode);
            }

            startNode.edges.add(finishNode);
        }

        private Node getNode(Integer key) {
            for (Node v : graph) {
                if (v.key.equals(key)) {
                    return v;
                }
            }

            return null;
        }

    }

    static class Node {
        private Integer key;
        List<Node> edges = new LinkedList<>();
    }

    private static boolean hasCycle(Node root) {
        Stack<Integer> recStack = new Stack<>();
        return hasCycle(root, recStack);
    }

    private static boolean hasCycle(Node root, Stack<Integer> stack) {
        if (stack.contains(root.key)) {
            return true;
        } else {
            stack.add(root.key);
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
