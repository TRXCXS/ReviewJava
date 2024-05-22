package BinaryTree;

// 39 https://leetcode.cn/problems/binary-tree-preorder-traversal/description/

import java.util.ArrayList;
import java.util.List;

public class IterativeTraversalOfBinaryTree {
    public void preorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalBinaryTree(list, root);
        return list;
    }
}
