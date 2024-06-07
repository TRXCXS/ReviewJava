package BacktrackingAlgorithm;

// 81 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private List<String> result = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            backtracking(digits, 0);
        }
        return result;
    }

    public void backtracking(String digits, int index) {
        if (stringBuilder.length() == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        // index是digits的索引，current是digits[index]对应的字符串
        String current = strings[digits.charAt(index) - '0'];
        for (int i = 0; i < current.length(); i++) {
            stringBuilder.append(current.charAt(i));
            backtracking(digits, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
