package String;

// 25 https://leetcode.cn/problems/reverse-words-in-a-string/description/

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        // left的位置应该在一个单词的首字母左边，right的位置应该在一个单词的最后一个字母
        int left = s.length() - 1, right;
        // 跳过末尾空格，直到最后一个单词的最后一个字母，或到index=-1（无单词）
        while (left >= 0 && s.charAt(left) == ' ') {
            left--;
        }
        right = left;
        // 无单词的情况
        if (left < 0) {
            return "";
        }

        // 有单词的情况
        StringBuilder result = new StringBuilder();
        while (true) {
            // left尝试到达单词的首字母左边
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            // 添加单词
            result.append(s, left + 1, right + 1);

            // left已经到达index=-1，结束循环
            if (left < 0) {
                return result.toString();
            }
            // left前面可能还有空格，尝试跳过它们
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }

            if (left < 0) {
                // left经过一段空格，前面已没有单词，结束循环
                return result.toString();
            } else {
                // left到达新单词的最后一个字母
                right = left;
            }
            // 还有单词，则加上空格
            result.append(' ');
        }
    }
}
