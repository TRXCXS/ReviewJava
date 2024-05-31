package BinaryTree;

// 66 https://leetcode.cn/problems/maximum-binary-tree/

public class MaximumBinaryTree {
    public int findMax(int[] nums, int left, int right) {
        int max = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int pivot = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[pivot]);
        root.left = constructMaximumBinaryTree(nums, left, pivot - 1);
        root.right = constructMaximumBinaryTree(nums, pivot + 1, right);
        return root;
    }
}
