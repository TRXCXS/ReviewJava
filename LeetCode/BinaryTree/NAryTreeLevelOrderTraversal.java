package BinaryTree;

// 49 https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        int levelSize = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (list.size() < levelSize) {
                Node temp = queue.poll();
                if (temp != null) {
                    queue.addAll(temp.children);
                    list.add(temp.val);
                }
            }
            result.add(list);
        }

        return result;
    }
}