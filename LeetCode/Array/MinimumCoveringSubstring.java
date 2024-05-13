package Array;

// 06 https://leetcode.cn/problems/minimum-window-substring/description/

/**
 * 滑动窗口的核心思路
 * 右边界持续扩展，左边界持续尝试缩小，在这个过程中，记录符合条件的最短的边界下标
 */

import java.util.HashMap;

public class MinimumCoveringSubstring {
    public boolean isCovered(
            HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        for (char c : tMap.keySet()) {
            if (sMap.get(c) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        // 长度不足，必然无法覆盖
        if (s == null || s.length() < t.length()) {
            return "";
        }

        // 初始化tMap和sMap，分别用于统计t和s中每个字符出现的次数
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            sMap.put(t.charAt(i), 0);
        }

        // 初始长度为最大值，之后若存在更短子串，则记录窗口左右位置
        int left = 0, right = 0, minLeft = 0, minRight = 0, length = Integer.MAX_VALUE;
        for (; left <= s.length() - t.length() && right < s.length(); right++) {
            // 更新sMap
            if (sMap.containsKey(s.charAt(right))) {
                sMap.put(s.charAt(right), sMap.get(s.charAt(right)) + 1);
            }
            // 若当前区间满足覆盖条件，则左指针持续右移，尝试缩短窗口长度
            while (left <= s.length() - t.length() && isCovered(sMap, tMap)) {
                if (!sMap.containsKey(s.charAt(left))) {
                    // left不是key，窗口左侧直接右移
                    left++;
                } else {
                    // left是key考虑其是否对覆盖有影响
                    if (sMap.get(s.charAt(left)) - 1 < tMap.get(s.charAt(left))) {
                        // 有影响，不能右移
                        break;
                    } else {
                        // 无影响，修改sMap中key对应的值，完成右移
                        sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                        left++;
                    }
                }
            }
            // 若当前区间满足覆盖条件，则记录窗口左右位置
            if (isCovered(sMap, tMap) && right - left + 1 < length) {
                length = right - left + 1;
                minLeft = left;
                minRight = right;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }
}
