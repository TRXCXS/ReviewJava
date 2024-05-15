package HashTable;

// 15 https://leetcode.cn/problems/intersection-of-two-arrays/description/

/**
 * set1存储nums1中出现过的元素，set2存储nums1和nums2的交集
 */

import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] res = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            res[i++] = num;
        }
        return res;
    }
}
