package LinkedList;

// 08 https://leetcode.cn/problems/design-linked-list/

class MyLinkedList {
    // 虚拟头结点
    private ListNode head;

    public MyLinkedList() {
        // 使用head的val存储链表中的元素个数
        head = new ListNode(0);
    }

    public int get(int index) {
        System.out.println(head.val);

        if (index < 0 || index >= head.val) {
            return -1;
        }

        ListNode cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
        head.val++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        head.val++;
    }

    public void addAtIndex(int index, int val) {
        if (index >= head.val || index < 0) {
            return;
        }

        ListNode node = new ListNode(val);
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        head.val++;
    }

    public void deleteAtIndex(int index) {
        if (index >= head.val || index < 0) {
            return;
        }

        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        head.val--;
    }
}
