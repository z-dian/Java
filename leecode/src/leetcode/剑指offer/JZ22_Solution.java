package leetcode.剑指offer;


/**
 * @author 张点
 * @description 链表中倒数第k个节点
 * @date 2020/10/30 9:49
 **/
public class JZ22_Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
