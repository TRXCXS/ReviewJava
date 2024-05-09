package Array;

// 04 https://leetcode.cn/problems/minimum-size-subarray-sum/description/

public class MinimumLengthSubarray {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, currSum = 0;
        for (; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum > target) {
                currSum -= nums[left];
                left++;
            }
        }
        return right - left;
    }
}
