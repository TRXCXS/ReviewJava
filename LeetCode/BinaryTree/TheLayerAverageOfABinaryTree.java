package BinaryTree;

// 48 https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TheLayerAverageOfABinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Double>> record = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        int levelSize = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            List<Double> list = new ArrayList<>();
            while (list.size() < levelSize) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    list.add((double) temp.val);
                }
            }
            record.add(list);
        }

        for (List<Double> list : record) {
            double sum = 0;
            for (Double number : list) {
                sum += number;
            }
            result.add(sum / list.size());
        }
        return result;
    }
}
