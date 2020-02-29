package com.alexbzmn;

import com.alexbzmn.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstructBT {
    int i = 0;
    public static void main(String[] args) {

        TreeNode res = new ConstructBT().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(res);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }

        Set<Integer> v = new HashSet<>();
        return build(preorder, inorder, m, 0, inorder.length - 1, v);
    }

    private TreeNode build(int[] preorder, int[] inorder, Map<Integer, Integer> m, int s, int f, Set<Integer> v) {
        if (s > f) {
            return null;
        }

        if (v.contains(inorder[s]) || v.contains(inorder[f])) {
            return null;
        }

        TreeNode n = new TreeNode(preorder[i++]);
        v.add(n.val);

        int index = m.get(n.val);

        n.left = build(preorder, inorder, m, s, index - 1, v);
        n.right = build(preorder, inorder, m, index + 1, f, v);

        return n;
    }
}
