package StackAndQueue;

// 30 https://leetcode.cn/problems/implement-stack-using-queues/

/**
 * pop和top时使用backupQueue来备份mainQueue的前n-1个元素，以拿到最后进入的元素
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    private final Queue<Integer> mainQueue;
    private final Queue<Integer> backupQueue;

    public MyStack() {
        mainQueue = new ArrayDeque<>();
        backupQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        mainQueue.add(x);
    }

    public int pop() {
        dataBackup();
        int e = mainQueue.remove();
        dataRecovery();

        return e;
    }

    public int top() {
        dataBackup();
        int e = mainQueue.remove();
        dataRecovery();
        mainQueue.add(e);

        return e;
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }

    public void dataBackup() {
        // 将前面的n-1个元素备份到backupQueue

        while (mainQueue.size() > 1) {
            backupQueue.add(mainQueue.remove());
        }
    }

    public void dataRecovery() {
        // 将backupQueue中的元素恢复到mainQueue

        while (!backupQueue.isEmpty()) {
            mainQueue.add(backupQueue.remove());
        }
    }
}
