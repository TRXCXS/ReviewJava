package BinaryTree;

// 77 https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/

/**
 * 每次找数组区间中点的值插入，这样构成的就是一棵二叉平衡树
 */

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0, nums.length - 1);
    }

    public TreeNode insert(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert(nums, left, mid - 1);
        root.right = insert(nums, mid + 1, right);
        return root;
    }
}
