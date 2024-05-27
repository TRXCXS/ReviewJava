package BinaryTree;

// 55 https://leetcode.cn/problems/invert-binary-tree/description/

public class FlipBinaryTree {
    public void invertBinaryTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        invertBinaryTree(root);
        return root;
    }
}
