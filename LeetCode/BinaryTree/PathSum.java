package BinaryTree;

// 62 https://leetcode.cn/problems/path-sum/description/

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    private boolean result = false;

    public void findPath(TreeNode root, List<Integer> path, int targetSum) {
        path.add(root.val);
        if (root.left == null && root.right == null && path.stream().mapToInt(Integer::intValue).sum() == targetSum) {
            result = true;
        }
        if (!result && root.left != null) {
            findPath(root.left, path, targetSum);
            path.removeLast();
        }
        if (!result && root.right != null) {
            findPath(root.right, path, targetSum);
            path.removeLast();
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        List<Integer> path = new ArrayList<>();
        findPath(root, path, targetSum);
        return result;
    }
}
