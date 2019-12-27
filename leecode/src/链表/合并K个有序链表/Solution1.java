package 链表.合并K个有序链表;

import 数组与字符串.两数相加.ListNode;

/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
示例:
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
思路：
1、合并数组中第K个链表到第1个链表，合并数组中第k-1个链表到第2个链表，依次合并
2、一轮合并完成后，新链表分布在数组的第1到第(k+1)/2个链表中，重复第一步知道链表只在数组第一个位置。
3、返回数组第一个元素，即合并之后的链表。

 */
public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        //将n个链表以中间为对称，合并
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len - i - 1]);
            }
            len = (len + 1) / 2;
        }
        return lists[0];
    }

    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }
}
