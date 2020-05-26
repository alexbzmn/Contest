package com.alexbzmn;

import com.alexbzmn.util.TreeNode;

public class LCA {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (root.equals(p) || root.equals(q)) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		if (left != null && (!left.equals(q) && !left.equals(p))) {
			return left;
		}

		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (right != null && (!right.equals(q) && !right.equals(p))) {
			return right;
		}

		if (left != null && right != null) {
			return root;
		}

		if (left != null) {
			return left;
		} else if (right != null) {
			return right;
		} else {
			return null;
		}

	}
}
