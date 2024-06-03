package BinaryTree;

// 71 https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindModeInBinarySearchTree {
    public int[] findModeOld(TreeNode root) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        inorderTraversalOld(root, countMap);
        int maxCount = 0;
        for (Integer count : countMap.values()) {
            maxCount = Math.max(maxCount, count);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == maxCount) {
                result.add(key);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void inorderTraversalOld(TreeNode root, HashMap<Integer, Integer> countMap) {
        if (root != null) {
            inorderTraversalOld(root.left, countMap);
            countMap.put(root.val, countMap.getOrDefault(root.val, 0) + 1);
            inorderTraversalOld(root.right, countMap);
        }
    }

    List<Integer> result = new ArrayList<>();
    int last = Integer.MIN_VALUE, count = 0, maxCount = 0;

    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            if (last == Integer.MIN_VALUE || last != root.val) {
                count = 1;
            } else {
                count++;
            }
            last = root.val;

            if (count == maxCount) {
                result.add(root.val);
            }
            if (count > maxCount) {
                result.clear();
                result.add(root.val);
                maxCount = count;
            }
            inorderTraversal(root.right);
        }
    }
}