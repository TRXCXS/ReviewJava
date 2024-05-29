package BinaryTree;

// 63 https://leetcode.cn/problems/path-sum-ii/description/

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public void findPath(TreeNode root, List<Integer> path, int targetSum, List<List<Integer>> resultPaths) {
        path.add(root.val);
        if (root.left == null && root.right == null && path.stream().mapToInt(Integer::intValue).sum() == targetSum) {
            resultPaths.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            findPath(root.left, path, targetSum, resultPaths);
            path.removeLast();
        }
        if (root.right != null) {
            findPath(root.right, path, targetSum, resultPaths);
            path.removeLast();
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resultPaths = new ArrayList<>();
        if (root == null) {
            return resultPaths;
        }
        List<Integer> path = new ArrayList<>();
        findPath(root, path, targetSum, resultPaths);
        return resultPaths;
    }
}
