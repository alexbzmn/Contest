package com.alexbzmn;

import com.alexbzmn.util.TreeNode;

public class ValidBst {

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
//        System.out.println(new ValidBst().isValidBST(treeNode));


        TreeNode tree = new TreeNode(3,
                new TreeNode(2,
                        new TreeNode(1,
                                new TreeNode(0, null, null), null),
                        new TreeNode(3,
                                null,
                                new TreeNode(4, null, null))),
                new TreeNode(5,
                        new TreeNode(4, null, null),
                        new TreeNode(6, null, null)));

        System.out.println(isBST(tree, null, null));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (isValidBST(root.left) && isValidBST(root.right)) {
            return (root.left == null || root.left.val < root.val)
                    && (root.right == null || root.right.val > root.val);
        }

        return false;
    }

    static boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
        // Base condition
        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.val <= l.val)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.val >= r.val)
            return false;

        // check recursively for every node.
        return isBST(root.left, l, root) &&
                isBST(root.right, root, r);
    }

}
