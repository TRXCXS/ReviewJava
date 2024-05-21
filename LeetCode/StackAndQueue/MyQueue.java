package StackAndQueue;

// 29 https://leetcode.cn/problems/implement-queue-using-stacks/description/

/**
 * stackIn负责接收，stackOut负责输出
 * stackOut为空时，将stackIn中的元素全部弹出到stackOut中，这样可以保证先入队的在stackOut栈顶，使得其先可以出队
 */

import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> stackIn;
    private final Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }
}
