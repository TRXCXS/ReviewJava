package BinaryTree;

// 69 https://leetcode.cn/problems/validate-binary-search-tree/description/

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
}