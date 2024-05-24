package BinaryTree;

// 45 https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
// 46 https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/

/**
 * 1. 使用队列完成层序遍历
 * 2. 使用levelSize通过队列大小记录每层的节点个数，从而判断当前层是否遍历完成
 * <p>
 * 自底向上直接将result反转即可
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int levelSize = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (list.size() < levelSize) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    list.add(temp.val);
                }
            }
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int levelSize = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (list.size() < levelSize) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    list.add(temp.val);
                }
            }
            result.add(list);
        }
        return result.reversed();
    }
}
