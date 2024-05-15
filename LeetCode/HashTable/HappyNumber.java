package HashTable;

// 16 https://leetcode.cn/problems/happy-number/description/

/**
 * 非快乐数会陷入循环。使用set存储已经出现过的数字，如果出现重复，则说明非快乐数。
 */

import java.util.HashSet;

public class HappyNumber {
    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            } else {
                if (set.contains(n)) {
                    return false;
                } else {
                    set.add(n);
                }
            }
            n = getNext(n);
        }
    }
}
