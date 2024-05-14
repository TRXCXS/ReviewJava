package LinkedList;

// 11 https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/

/**
 * 双指针：fast先走n步，当fast走到最后一个节点时，low的下一个节点即为待删除节点
 */

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode VHead = new ListNode();
        VHead.next = head;

        ListNode low = VHead, fast = VHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            low = low.next;
            fast = fast.next;
        }
        low.next = low.next.next;
        return VHead.next;
    }
}
