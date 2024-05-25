package BinaryTree;

// 50 https://leetcode.cn/problems/find-largest-value-in-each-tree-row/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindTheMaximumValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Integer>> record = new ArrayList<>();
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
            record.add(list);
        }

        for (List<Integer> list : record) {
            int max = Integer.MIN_VALUE;
            for (int number : list) {
                if (number > max) {
                    max = number;
                }
            }
            result.add(max);
        }
        return result;
    }
}
