package 链表.反转链表;
/*
题目描述：
反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

思路：
我们可以申请两个指针，第一个指针叫pre，最初是指向null的。
第二个指针cur指向head，然后不断遍历cur。
每次迭代到cur，都将cur的next指向pre，然后pre和cur前进一位。
都迭代完了(cur变成null了)，pre就是最后一个节点了。
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre=curr;
            curr=nextTemp;
        }
        return pre;
    }
}
