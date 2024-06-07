package BacktrackingAlgorithm;

// 80 https://leetcode.cn/problems/combination-sum-iii/description/

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    // 和是n，数的数量是k
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    public void backtracking(int k, int n, int startIndex, int sum) {
        if (sum == n && list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; sum < n && i <= 10 - k + list.size(); i++) {
            list.add(i);
            sum += i;
            backtracking(k, n, i + 1, sum);
            list.removeLast();
            sum -= i;
        }
    }
}
