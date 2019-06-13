package cn.plantlink.algorithm.list;

/**
 * 两个无环的单链表有个交点，找到这个点
 */
public class LinkedListIntersection {

    // A: a1 → a2→ c1 → c2 → c3
    // B: b1 → b2 → b3 → c1 → c2 → c3
    // 双指针同时遍历两个链表，到结尾后跳到另一个链表的头继续遍历，时间复杂度O(n)，空间复杂度O(1)
    public static ListNode getIntersection(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {

            node1 = node1.next;
            node2 = node2.next;

            if (node1 == node2) {
                return node1;
            }

            if (node1 == null) {
                node1 = headB;
            }

            if (node2 == null) {
                node2 = headA;
            }
        }

        return node1;
    }

    class ListNode {

        private String value;
        private ListNode next;

        public ListNode(String value) {
            this.value = value;
            next = null;
        }
    }
}
