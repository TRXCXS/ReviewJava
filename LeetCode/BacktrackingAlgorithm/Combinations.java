package BacktrackingAlgorithm;

// 79 https://leetcode.cn/problems/combinations/description/

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        // list的大小等于k时，说明已经找到了一个组合
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 控制树的横向遍历
        for (int i = startIndex; i <= n - k + 1 + list.size(); i++) {
            // 加入当前节点
            list.add(i);
            // 递归：控制树的纵向遍历。注意下一层搜索要从i+1开始
            backtracking(n, k, i + 1);
            // 回溯，撤销处理的节点
            list.removeLast();
        }
    }
}
