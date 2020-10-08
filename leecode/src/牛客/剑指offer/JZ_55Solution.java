package 牛客.剑指offer;

/**
 * @author 张点
 * @description 链表中的环的入口点
 * @date 2020/10/3 12:00
 **/
public class JZ_55Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (pHead != null && pHead.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        fast = pHead;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
