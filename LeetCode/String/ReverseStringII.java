package String;

// 23 https://leetcode.cn/problems/reverse-string-ii/description/

import java.util.Arrays;

public class ReverseStringII {
    public void reverseString(char[] string, int start, int end) {
        while (start < end) {
            char temp = string[start];
            string[start] = string[end];
            string[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseStr(String s, int k) {
        int length = s.length();
        char[] string = s.toCharArray();

        for (int i = 0; i < length; i += 2 * k) {
            int remainingCharactersNumber = length - i;
            if (remainingCharactersNumber < k) {
                reverseString(string, i, length - 1);
            } else {
                reverseString(string, i, i + k - 1);
            }
        }
        return new String(string);
    }
}
