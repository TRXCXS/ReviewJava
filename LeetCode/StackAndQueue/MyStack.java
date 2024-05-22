package StackAndQueue;

// 30 https://leetcode.cn/problems/implement-stack-using-queues/

/**
 * 用一个队列就可以模拟栈
 * 把前n-1个元素移到队列末尾，再对最后一个元素进行操作，即可以实现栈后进先出的特性
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    private final Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
        return queue.remove();
    }

    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
        int e = queue.remove();
        queue.add(e);

        return e;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
