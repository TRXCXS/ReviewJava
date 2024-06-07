package BacktrackingAlgorithm;

// 82 https://leetcode.cn/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

            list.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i, sum);
            sum -= candidates[i];
            list.removeLast();
        }
    }
}
