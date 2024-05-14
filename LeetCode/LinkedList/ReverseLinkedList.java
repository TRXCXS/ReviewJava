package LinkedList;

// 09 https://leetcode.cn/problems/reverse-linked-list/description/

/**
 * 头插法
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode VHead = new ListNode();
        VHead.next = null;

        ListNode pre = VHead, cur = head, tempPre, tempCur;
        while (cur != null) {
            // 把cur指向的结点插入到pre后面
            tempCur = cur.next;
            tempPre = pre.next;
            pre.next = cur;
            cur.next = tempPre;
            cur = tempCur;
        }
        return VHead.next;
    }
}
