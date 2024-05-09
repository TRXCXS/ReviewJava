package Array;

// 03 https://leetcode.cn/problems/squares-of-a-sorted-array/description/

/**
 * 题目：数组元素的平方仍然有序
 * 思路：双指针从两端向中间逼近
 */

public class SquareOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                ans[index] = nums[left] * nums[left];
                left++;
            } else {
                ans[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return ans;
    }
}
