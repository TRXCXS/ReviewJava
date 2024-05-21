package StackAndQueue;

// 32 https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/

import java.util.Stack;

public class DeleteAllAdjacentDuplicatesInTheString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}

