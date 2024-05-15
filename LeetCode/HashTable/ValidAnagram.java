package HashTable;

// 14 https://leetcode.cn/problems/valid-anagram/description/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> sMap = new HashMap<>();
//        HashMap<Character, Integer> tMap = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
//        }
//
//        if (sMap.size() != tMap.size()) {
//            return false;
//        }
//        for (Character c : sMap.keySet()) {
//            if (!tMap.containsKey(c) || !sMap.get(c).equals(tMap.get(c))) {
//                return false;
//            }
//        }
//        return true;

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
