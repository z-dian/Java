package 链表.奇偶链表;

/*
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
示例 1:
输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
示例 2:
输入: 2->1->3->5->6->4->7->NULL
输出: 2->3->6->7->1->5->4->NULL
 */
public class Solution {
    /*
    思路:
    1）初始化odd（当前奇节点）、even（当前偶节点）、evenHead（偶节点链表头部）
    odd = head,even = head.next,evenHead=even;
    2）遍历链表：当even.next!=null 且 even.next !=null时进行如下操作
        让第一个奇节点跳过其后面的偶节点，指向其下一个奇节点：odd.next = even.next;
        当前奇节点指针odd向后走：odd = odd.next;
        奇节点后面的节点为偶节点,加到偶链表中：even.next = odd.next;
        当前偶节点向后走：even = even.next;
    3）遍历完成后生成一奇链表和一偶链表，将偶链表的头部连在奇链表的尾部，合并成一个链表
        odd.next = evenHead;
    4）返回头结点：return head;

     */
    public ListNode oddEvenList(ListNode head) {
        //特判：头结点为空，返回null
        if (head == null) return null;
        //初始化odd（当前奇节点）、even（当前偶节点）、evenHead（偶节点链表头部）
        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            //让第一个奇节点跳过其后面的偶节点，指向其下一个奇节点：odd.next = even.next;
            odd.next = even.next;
            //当前奇节点指针odd向后走：odd = odd.next;
            odd = odd.next;
            //奇节点后面的节点为偶节点,加到偶链表中：even.next = odd.next;
            even.next = odd.next;
            //当前偶节点向后走：even = even.next;
            even = even.next;
        }
        //遍历完成后生成一奇链表和一偶链表，将偶链表的头部连在奇链表的尾部，合并成一个链表
        odd.next = evenHead;
        return head;
    }
}
