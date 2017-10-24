package com.alexbzmn.ds;

import java.text.MessageFormat;

public class Edge implements Comparable<Edge> {
    public int src;
    public int dest;
    public Integer cost;

    @Override
    public int compareTo(Edge o) {
        return this.cost.compareTo(o.cost);
    }

    @Override
    public String toString() {
        return MessageFormat.format("{2}=({0},{1})", src, dest, cost);
    }
}
