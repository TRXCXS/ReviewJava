package HashTable;

// 18 https://leetcode.cn/problems/4sum-ii/description/

/**
 * 先用哈希表存储num1+num2出现的次数，然后遍历num3+num4，如果-(num3+num4)在哈希表中，则count+=哈希表中的值
 */

import java.util.HashMap;

public class AdditionOfFourNumbers {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                count += map.getOrDefault(-(num3 + num4), 0);
            }
        }
        return count;
    }
}
