package String;

// 28 https://leetcode.cn/problems/repeated-substring-pattern/description/

public class RepeatedSubstring {
    /*
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= s.length() / 2; i++) {
            if (length % i == 0) {
                list.add(i);
            }
        }

        for (Integer substringLength : list) {
            String temp = s.substring(0, substringLength).repeat(length / substringLength);
            if (temp.equals(s)) {
                return true;
            }
        }
        return false;
    }
    */

    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        int prefixLength = 0;

        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(prefixLength)) {
                prefixLength++;
                next[i] = prefixLength;
                i++;
            } else {
                if (prefixLength == 0) {
                    next[i] = 0;
                    i++;
                } else {
                    prefixLength = next[prefixLength - 1];
                }
            }
        }

        return next;
    }

    public int kmp(String s2, String s) {
        int[] next = getNext(s);

        for (int i = 0, j = 0; i < s2.length(); ) {
            if (s2.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }

            if (j == s.length()) {
                return i - j;
            }
        }

        return -1;
    }

    public boolean repeatedSubstringPattern(String s) {
        String s2 = s + s;
        s2 = s2.substring(1, s2.length() - 1);

        return kmp(s2, s) != -1;
    }
}
