package com.alexbzmn.util;

import java.util.LinkedList;
import java.util.List;

public class GraphBuilder {
    public List<Node> graph = new LinkedList<>();

    public void addEdge(Integer start, Integer finish) {
        Node startNode = null;
        Node finishNode = null;

        for (Node v : graph) {
            if (v.val.equals(start)) {
                startNode = v;
            }
            if (v.val.equals(finish)) {
                finishNode = v;
            }
        }

        if (startNode == null) {
            startNode = new Node();
            startNode.val = start;
            graph.add(startNode);
        }

        if (finishNode == null) {
            finishNode = new Node();
            finishNode.val = finish;
            graph.add(finishNode);
        }

        startNode.edges.add(finishNode);
    }

    public Node getNode(Integer key) {
        for (Node v : graph) {
            if (v.val.equals(key)) {
                return v;
            }
        }

        return null;
    }

}
