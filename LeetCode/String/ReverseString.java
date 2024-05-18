package String;

// 22 https://leetcode.cn/problems/reverse-string/description/

public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = t;
        }
    }
}
