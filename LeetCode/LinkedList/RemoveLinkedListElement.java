package LinkedList;

// 07 https://leetcode.cn/problems/remove-linked-list-elements/

/**
 * 设置一个虚拟头结点来统一对所有结点的处理方式
 */

public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode VHead = new ListNode();
        VHead.next = head;

        ListNode pre = VHead, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return VHead.next;
    }
}
