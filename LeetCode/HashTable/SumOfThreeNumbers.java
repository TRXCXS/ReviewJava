package HashTable;

// 20 https://leetcode.cn/problems/3sum/description/

/**
 * 对于序列：x -1 -1 0 1
 * i第一次取到-1的时候就已经处理了-1 0 1的情况
 * i第二次取到-1的时候，会重复出现-1 0 1的情况
 * 因此，如果nums[i] == nums[i - 1]，则跳过。因为这样即使能得到解，也会和之前的解重复。
 * 在上面的例子中，i对应的就是第二个-1，它和前面的-1重复了，得到的解也会是重复的。
 * <p>
 * 而对于-1 -1 0 1 2的情况
 * 跳过第二个-1可以避免-1 0 1的重复 √
 * 如果跳过第一个-1，则会导致-1 -1 2的缺失 ×
 * <p>
 * 总结：对于i重复的情况，第一个i会包括之后所有可能的解。因此第一个i不能跳过，而之后重复的i则应该跳过
 * 即：i与前一个重复，则跳过这个i
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThreeNumbers {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < 0) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 在当前i下考虑下一组可能的组合
                    // 这里left跳过的逻辑和i一样，right反方向同理
                    for (left++; left < right && nums[left] == nums[left - 1]; ) {
                        left++;
                    }
                    for (right--; left < right && nums[right] == nums[right + 1]; ) {
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
