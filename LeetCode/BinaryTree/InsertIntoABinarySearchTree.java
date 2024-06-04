package BinaryTree;

// 74 https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insert(root.left, val);
            }
        }
        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insert(root.right, val);
            }
        }
    }
}
