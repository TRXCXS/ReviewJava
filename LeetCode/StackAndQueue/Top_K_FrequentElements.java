package StackAndQueue;

// 35 https://leetcode.cn/problems/top-k-frequent-elements/description/

/**
 * 使用map记录每个元素出现的频次
 * 使用优先级队列完成排序，保留频次最高的K个元素，具体过程是：
 * 1. 优先级队列存储元素和频次，且以频次升序排序，这样构造的优先级队列是小顶堆，即堆顶是频次最低的元素
 * 2. 遍历map：当队列大小小于K时，直接添加元素；否则比较当前元素频次和队列中最小频次元素的频次，如果当前元素频次较大，则替换队列中最小频次元素
 * 3. 遍历结束后，队列中剩下的元素即为频次最高的K个元素
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_FrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                // 实现排序接口，这是是升序排序，则构造的优先队列是小顶堆，符合我们的需要
                // 如果排序规则是(a, b) -> b[1] - a[1] ，则是大顶堆
                Comparator.comparingInt(a -> a[1])
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            } else if (priorityQueue.peek() != null && priorityQueue.peek()[1] < entry.getValue()) {
                priorityQueue.poll();
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int index = 0;
        int[] result = new int[k];
        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll()[0];
        }

        return result;
    }
}
