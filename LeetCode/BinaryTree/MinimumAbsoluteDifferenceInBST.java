package BinaryTree;

// 70 https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/

public class MinimumAbsoluteDifferenceInBST {
    int last = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return min;
    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            if (last != -1 && root.val - last < min) {
                min = root.val - last;
            }
            last = root.val;
            inorderTraversal(root.right);
        }
    }
}