package BinaryTree;

// 58 https://leetcode.cn/problems/balanced-binary-tree/description/

public class BalancedBinaryTree {
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return getMaxDepth(root.right) + 1;
        }
        if (root.right == null) {
            return getMaxDepth(root.left) + 1;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null) {
            return getMaxDepth(root.right) <= 1;
        }
        if (root.right == null) {
            return getMaxDepth(root.left) <= 1;
        }
        return Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }
}
