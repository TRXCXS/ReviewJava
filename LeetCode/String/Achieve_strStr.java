package String;

// 27 https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

public class Achieve_strStr {
    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        // prefixLength代表当前公共前后缀长度
        // 考虑初始的第一个字符，公共前后缀长度为0，则next[0] = 0
        int prefixLength = 0;
        next[0] = 0;

        int i = 1; // 从第二个字符开始遍历
        while (i < needle.length()) {
            // 对于此时的i和prefixLength
            // 上一个子串是[0,i-1]，对应最长公共前缀是[0,prefixLength-1]，对应最长公共后缀是[i-prefixLength,i-1]

            if (needle.charAt(i) == needle.charAt(prefixLength)) {
                // 如果相等，则[0,prefixLength]对应子串和[i-prefixLength,i]对应子串相等，于是构成新的最长公共前后缀
                // 最长公共前后缀长度+1
                prefixLength++;
                // 最长公共前后缀长度对应的是此时的i，记录到next数组中
                next[i] = prefixLength;
                // i++，继续遍历下一个字符
                i++;
            } else {
                if (prefixLength == 0) {
                    // 公共前后缀的长度只能一个一个增长，不能跳跃
                    // ①考虑[0,i]的公共前后缀长度是2，则s[0]==s[i-1]且s[1]==s[i]，则[0,i-1]的公共前后缀长度是1，因为s[0]==s[i-1]
                    // ②反之，若[0,i]的公共前后缀长度是0，则意味着[1,i]里面没有任何一个字符等于s[0]
                    // 此时来一个字符如果等于s[0]，则[0,i+1]的公共前后缀长度变成1，否则仍然无法构成公共前后缀，即公共前后缀长度仍为0
                    // 总结：公共前后缀长度一次最多增加一个

                    // 公共前后缀长度是0的情况下，新来的字符s[i]仍然不等于s[0]，则仍然无法构成公共前后缀
                    next[i] = 0;
                    // 继续遍历下一个字符，直到其等于s[0]，才开始构成公共前后缀
                    i++;
                } else {
                    prefixLength = next[prefixLength - 1];
                }
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);

        for (int i = 0, j = 0; i < haystack.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }

            if (j == needle.length()) {
                return i - j;
            }
        }

        return -1;
    }
}
