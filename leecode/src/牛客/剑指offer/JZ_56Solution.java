package 牛客.剑指offer;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author 张点
 * @description 删除链表中重复的结点
 * @date 2020/10/4 13:16
 **/
public class JZ_56Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                pre.next = current.next;
                current = current.next;
            }else {
                pre = pre.next;
                current = current.next;
            }
        }
        return head.next;
    }
}
