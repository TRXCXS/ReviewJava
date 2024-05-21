package StackAndQueue;

// 31 https://leetcode.cn/problems/valid-parentheses/description/

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (currChar == ')' && c != '(' ||
                        currChar == '}' && c != '{' ||
                        currChar == ']' && c != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
