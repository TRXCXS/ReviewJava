package LinkedList;

// 12 https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/

/**
 * 寻找相交节点
 * 第一步，确定长度
 * 第二步，尾部对齐
 * 第三步，寻找交点
 */

public class LinkedListIntersection {
    public int getLength(ListNode head) {
        int length = 0;
        for (; head != null; head = head.next) {
            length++;
        }
        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = getLength(headA), lengthB = getLength(headB);
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
