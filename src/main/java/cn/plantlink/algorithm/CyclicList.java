package cn.plantlink.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断有环链表
 */
public class CyclicList {

    // 辅助集合，时间复杂度O(n)，空间复杂度O(n)
    public static boolean hasCycleWithSet(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; null != p; p = p.next) {
            if (set.contains(p)) {
                return true;
            } else {
                set.add(p);
            }
        }

        return false;
    }

    // 快慢指针，时间复杂度O(n)，空间复杂度O(1)
    public static boolean hasCycleWithDoublePoints(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (null != fast && null != fast.next) {
            // 双指针降低空间复杂度
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
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
