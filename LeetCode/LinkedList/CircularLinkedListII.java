package LinkedList;

// 13 https://leetcode.cn/problems/linked-list-cycle-ii/description/

/**
 * fast每次走两步，slow每次走一步，如果fast和slow相遇，说明有环，否则没有环
 * <p>
 * 在有环的情况下：
 * head到环的入口的距离是x，环的入口到相遇的地方的距离是y，相遇的地方到环的入口的距离是z
 * 快指针走过的距离是x+y+n(y+z)，慢指针走过的距离是x+y，所以x+y+n(y+z) = 2(x+y)
 * 所以x=(n-1)(y+z)+z
 * 此时让新指针p从head出发，q从相遇点出发，二者都以每次一步的速度走，二者相遇的地方即为环的入口
 * 其中n-1表示q在遇到p之前多绕的圈数
 */

public class CircularLinkedListII {
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head)) {
//                return head;
//            }
//            set.add(head);
//            head = head.next;
//        }
//        return null;
//    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        } while (fast != slow);

        ListNode p = head, q = slow;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
