package Array;

// 06 https://leetcode.cn/problems/minimum-window-substring/description/

import java.util.HashMap;
import java.util.function.ToDoubleBiFunction;

public class MinimumCoveringSubstring {
    public boolean isCovered(String s, int left, int right,
                             HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        // 统计区间中每个字符出现的次数
        for (int i = left; i <= right; i++) {
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            }
        }

        boolean flag = true;
        // 判断区间内每个字符是否满足覆盖条件
        for (Character key : sMap.keySet()) {
            if (sMap.get(key) < tMap.get(key)) {
                flag = false;
                break;
            }
        }

        // 重置区间内每个字符出现的次数
        for (int i = 0; i < sMap.size(); i++) {
            sMap.put(s.charAt(i), 0);
        }
        return flag;
    }

    public String minWindow(String s, String t) {
        // 长度不足，必然无法覆盖
        if (s == null || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        // 初始化tMap和sMap，分别用于统计t和s中每个字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            sMap.put(t.charAt(i), 0);
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            if (!isCovered(s, left, right, sMap, tMap)) {
                right++;
            }
            while (isCovered(s, left + 1, right, sMap, tMap)) {
                // 缩小窗口
                left++;
            }
        }

        return s.substring(left, right);
    }

    public static void main(String[] args) {
        System.out.println(
                new MinimumCoveringSubstring().
                        minWindow("ADOBECODEBANC", "ABC"));
    }
}
