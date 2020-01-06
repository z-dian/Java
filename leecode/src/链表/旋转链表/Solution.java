package 链表.旋转链表;

import 数组与字符串.两数相加.ListNode;

/*
合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
思路：
1、将链表链接成环
2、找到相应位置断开这个环
3、确定新的链表头和尾
 */
public class Solution {
    public ListNode rotateRight(ListNode head,int k){
        if(head==null)return null;
        if(head.next==null)return head;
        //old_tail指针从头结点开始遍历链表，确定节点数目
        ListNode old_tail = head;
        int n;
        for(n=1;old_tail.next!=null;n++){
            old_tail=old_tail.next;
        }
        //此时old_tail指向最后一个节点，old_tail.next=head，让其闭合成环
        old_tail.next=head;
        //寻找新的头结点:n-k%n
        //寻找新的尾结点:(n-k%n-1)
        ListNode new_tail = head;
        for(int i = 0;i<n-k%n-1;i++){
            new_tail=new_tail.next;
        }
        ListNode new_head=new_tail.next;
        //断开环
        new_tail.next=null;
        return new_head;
    }
}
