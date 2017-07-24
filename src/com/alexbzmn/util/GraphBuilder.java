package com.alexbzmn.util;

import java.util.LinkedList;
import java.util.List;

public class GraphBuilder {
    public List<Node> graph = new LinkedList<>();

    public void addEdge(Integer start, Integer finish) {
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

    public Node getNode(Integer key) {
        for (Node v : graph) {
            if (v.key.equals(key)) {
                return v;
            }
        }

        return null;
    }

}
