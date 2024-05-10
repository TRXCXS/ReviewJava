package Array;

// 04 https://leetcode.cn/problems/minimum-size-subarray-sum/description/

/**
 * 滑动窗口
 * 思路：通过尝试减去nums[left]尽可能地缩小窗口范围，在合适的时候更新最小长度
 */

public class MinimumLengthSubarray {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, currSum = 0, length = Integer.MAX_VALUE;
        for (; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum - nums[left] >= target) {
                currSum -= nums[left];
                left++;
            }
            if (currSum >= target && right - left + 1 < length) {
                length = right - left + 1;
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
