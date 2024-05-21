package StackAndQueue;

// 33 https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/

import java.util.Stack;

public class EvaluateInversePolishExpression {
    public boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                    case "*" -> stack.push(num1 * num2);
                    default -> stack.push(num1 / num2);
                }
            }
        }

        return stack.pop();
    }
}