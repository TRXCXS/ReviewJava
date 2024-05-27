package BinaryTree;

// 56 https://leetcode.cn/problems/symmetric-tree/description/

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric_0(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right != null || left != null && right == null) {
                return false;
            }
            if (left != null) {
                if (left.val != right.val) {
                    return false;
                }
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }
        }
        return true;
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
}
