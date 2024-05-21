package StackAndQueue;

// 34 https://leetcode.cn/problems/sliding-window-maximum/description/

public class MaximumSlidingWindowValue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            currentMax = Math.max(currentMax, nums[i]);
        }

        return null;
    }
}
