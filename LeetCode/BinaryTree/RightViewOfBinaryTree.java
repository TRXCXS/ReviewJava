package BinaryTree;

// 47 https://leetcode.cn/problems/binary-tree-right-side-view/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int levelSize = 0, index = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            index = 0;
            while (index < levelSize) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    if (index == levelSize - 1) {
                        result.add(temp.val);
                    }
                }
                index++;
            }
        }
        return result;
    }
}
