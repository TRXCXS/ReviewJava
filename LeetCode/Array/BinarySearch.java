package Array;

// 01 https://leetcode.cn/problems/binary-search/description/

/**
 * 二分查找
 * ①left=0,right=nums.length-1
 * ②left<=right
 * ③left=mid+1,right=mid-1
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return -1;
    }
}