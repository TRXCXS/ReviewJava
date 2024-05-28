package BinaryTree;

// 59 https://leetcode.cn/problems/binary-tree-paths/description/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public void traversal(TreeNode root, List<Integer> path, List<String> result) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                stringBuilder.append(path.get(i)).append("->");
            }
            stringBuilder.append(path.getLast());
            result.add(stringBuilder.toString());
        }
        if (root.left != null) {
            traversal(root.left, path, result);
            path.removeLast();
        }
        if (root.right != null) {
            traversal(root.right, path, result);
            path.removeLast();
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        traversal(root, path, result);
        return result;
    }
}
