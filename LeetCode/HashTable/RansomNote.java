package HashTable;

// 19 https://leetcode.cn/problems/ransom-note/description/

/**
 * 看magazine能不能覆盖ransomNote的全部字符
 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteCount = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteCount[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            ransomNoteCount[magazine.charAt(i) - 'a']--;
        }
        // 遍历数组，如果某个元素大于0，则说明ransomNote中存在magazine无法覆盖的某个字符，则返回false
        for (int i = 0; i < 26; i++) {
            if (ransomNoteCount[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
