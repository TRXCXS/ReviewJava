package BinaryTree;

// 36 https://leetcode.cn/problems/binary-tree-preorder-traversal/
// 37 https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
// 38 https://leetcode.cn/problems/binary-tree-postorder-traversal/description/

import java.util.ArrayList;
import java.util.List;

public class RecursiveTraversalOfBinaryTree {
    public void preorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
        if (treeNode != null) {
            list.add(treeNode.val);
            preorderTraversalBinaryTree(list, treeNode.left);
            preorderTraversalBinaryTree(list, treeNode.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalBinaryTree(list, root);
        return list;
    }

    public void inorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
        if (treeNode != null) {
            inorderTraversalBinaryTree(list, treeNode.left);
            list.add(treeNode.val);
            inorderTraversalBinaryTree(list, treeNode.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalBinaryTree(list, root);
        return list;
    }

    public void postorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
        if (treeNode != null) {
            postorderTraversalBinaryTree(list, treeNode.left);
            postorderTraversalBinaryTree(list, treeNode.right);
            list.add(treeNode.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalBinaryTree(list, root);
        return list;
    }
}