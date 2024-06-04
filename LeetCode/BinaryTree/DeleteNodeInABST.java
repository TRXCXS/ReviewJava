package BinaryTree;

// 75 https://leetcode.cn/problems/delete-node-in-a-bst/description/

public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 找不到要删除的节点，返回null
        if (root == null) {
            return null;
        }
        if (root.val != key) {
            // root不是要删除的节点，向左右子树递归
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
        } else {
            // root就是要删除的节点
            // ①root是叶子节点，直接删除
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            }
            // ②root只有一个子节点，将root替换为子节点
            if (root.left == null) {
                root = root.right;
                return root;
            }
            if (root.right == null) {
                root = root.left;
                return root;
            }
            // ③root左右子树都不为空
            // 1、找到右子树的最左下的节点，即右子树上最小的节点，这个节点一定是叶子节点
            TreeNode rightMinNode = root.right;
            while (rightMinNode.left != null) {
                rightMinNode = rightMinNode.left;
            }
            // 2、将左子树挂到右子树的最左下节点的左子树上，这样可以保证二叉搜索树的性质
            rightMinNode.left = root.left;
            // 3、此时的二叉搜索树状态转换为只有右子树的情况
            root = root.right;
            return root;
        }
        // 删除完成，返回整棵树的根节点
        return root;
    }
}
