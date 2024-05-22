package StackAndQueue;

// 34 https://leetcode.cn/problems/sliding-window-maximum/description/

import java.util.Deque;
import java.util.LinkedList;

public class MaximumSlidingWindowValue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        Deque<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            // 队首元素不在窗口内了，一定要把它移除
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.removeFirst();
            }
            // 每进队一个元素，就把它前面的比他小的元素都移除
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);

            if (!deque.isEmpty() && i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
