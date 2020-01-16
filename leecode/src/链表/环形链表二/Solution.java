package 链表.环形链表二;

import 数组与字符串.两数相加.ListNode;

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：
输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
思路：
快慢指针：当快慢指针相遇时退出循环，此时让快指针从链表头开始，也就是0开始，当快慢指针二次相遇时，
慢指针刚好走完环，而快指针刚好走完非环部分节点，此时相遇即为环入口节点，返回该节点。
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true){
            if(fast==null||fast.next==null)return null;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)break;
        }
        fast=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
