package BacktrackingAlgorithm;

// 81 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private List<String> result = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private HashMap<Character, String> map = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        return null;
    }

    public void backtracking(String digits, int index) {

    }
}
