package BinaryTree;

// 57 https://leetcode.cn/problems/count-complete-tree-nodes/description/

/**
 * h层的满二叉树的节点数是2^h - 1
 * 对于完全二叉树，把它拆分成若干个满二叉树，以节省内存
 */

public class CountCompleteTreeNodes {
    public int countNodes_0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left, right = root.right;
        int leftDepth = 1, rightDepth = 1;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (int) (Math.pow(2, leftDepth) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
