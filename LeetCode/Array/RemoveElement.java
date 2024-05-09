package Array;

// 02 https://leetcode.cn/problems/remove-element/description/

/**
 * 移除target元素
 * 双指针：fast寻找元素，low接收元素
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int low = 0, fast = 0;
        while (fast != nums.length) {
            if (nums[fast] != val) {
                nums[low] = nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }
}
