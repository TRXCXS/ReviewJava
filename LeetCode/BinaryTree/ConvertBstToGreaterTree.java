package BinaryTree;

// 78 https://leetcode.cn/problems/convert-bst-to-greater-tree/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertBstToGreaterTree {
    public TreeNode convertBST_Old(TreeNode root) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        inorderTraversal(root, list, map);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            map.get(list.get(i)).val = sum;
        }
        return root;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list, HashMap<Integer, TreeNode> map) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list, map);
        list.add(root.val);
        map.put(root.val, root);
        inorderTraversal(root.right, list, map);
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 中序遍历是升序，那反向中序遍历就是降序
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
