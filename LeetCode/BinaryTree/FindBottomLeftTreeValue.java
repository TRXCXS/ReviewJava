package BinaryTree;

// 61 https://leetcode.cn/problems/find-bottom-left-tree-value/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue_0(TreeNode root) {
        List<List<Integer>> record = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int levelSize;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (list.size() < levelSize) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    list.add(node.val);
                }
            }
            record.add(list);
        }
        return record.getLast().getFirst();
    }

    private int depth = -1;
    private int result = 0;

    public int findBottomLeftValue(TreeNode root) {
        find(root, 0);
        return result;
    }

    public void find(TreeNode root, int depth) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (depth > this.depth) {
                    this.depth = depth;
                    result = root.val;
                }
            }
            if (root.left != null) {
                find(root.left, depth + 1);
            }
            if (root.right != null) {
                find(root.right, depth + 1);
            }
        }
    }
}
