package LinkedList;

// 10 https://leetcode.cn/problems/swap-nodes-in-pairs/description/

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode VHead = new ListNode();
        VHead.next = head;

        ListNode prePre = VHead, pre = head, cur, tempPre;
        while (pre != null && pre.next != null) {
            // 获取cur和tempPre，为交换和下一次交换做准备
            cur = pre.next;
            tempPre = cur.next;
            // 交换pre和cur
            prePre.next = cur;
            cur.next = pre;
            pre.next = tempPre;
            // 设置下一次交换的prePre和pre
            prePre = pre;
            pre = tempPre;
        }
        return VHead.next;
    }
}
