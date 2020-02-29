package com.alexbzmn;

import com.alexbzmn.util.TreeNode;

import java.util.*;

public class ZigZagBTTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        map.put(0, new LinkedList<Integer>() {{
            add(root.val);
        }});
        order(map, root, 1);

        list.addAll(map.values());

        return list;
    }

    private void order(Map<Integer, LinkedList<Integer>> m, TreeNode node, int i) {

        if (node == null) {
            return;
        }
        LinkedList<Integer> l = null;

        if (m.containsKey(i)) {
            l = m.get(i);
        } else {
            l = new LinkedList<>();
        }

        if (node.left != null) {
            if ((i & 1) == 1) {
                l.addFirst(node.left.val);
            } else {
                l.addLast(node.left.val);
            }
        }

        if (node.right != null) {
            if ((i & 1) == 1) {
                l.addFirst(node.right.val);
            } else {
                l.addLast(node.right.val);
            }
        }

        if (!l.isEmpty()) {
            m.put(i, l);
        }

        order(m, node.left, i + 1);
        order(m, node.right, i + 1);
    }
}
