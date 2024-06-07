package BacktrackingAlgorithm;

// 83 https://leetcode.cn/problems/combination-sum-ii/description/

/**
 * 每一层的循环中，第一个元素不能跳过，其他元素如果和前一个元素相同，则跳过
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, sum);
        return result;
    }

    public void backtracking(int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                return;
            }

            // 这里是在同一层for循环遍历，在同一层的时候，如果当前元素和前一个元素相同，则跳过
            // 之所以跳过而不会导致答案缺失，是因为同一层for循环遍历的时候，如果当前元素和前一个元素相同，则说明含有这个元素的组合已经被全部找到了，所以不需要再考虑这个元素了
            // i>index是关键，如果i==index，那说明这是这一层的第一个元素，不能跳过。之后的就可以跳过了。
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.add(candidates[i]);
            sum += candidates[i];
            // 每个元素只能使用一次，所以i+1考虑下一个元素
            // 这里是往下一层递归，而不同层是可以重复的，因此不需要判断是否相同是否需要continue，直接往下一层走就是了
            backtracking(candidates, target, i + 1, sum);
            list.removeLast();
            sum -= candidates[i];
        }
    }
}
