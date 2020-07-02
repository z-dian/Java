package 链表.回文链表;

import java.time.Year;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/*
请判断一个链表是否为回文链表。
示例 1:
输入: 1->2
输出: false
示例 2:
输入: 1->2->2->1
输出: true
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {

    }

    //暴力法：
    /*public boolean isPalindrome(ListNode head) {

        List<Integer> nums = new ArrayList<>();
        ListNode cur_node = head;
        while (cur_node != null) {
            nums.add(cur_node.val);
            cur_node=cur_node.next;
        }

        int i = 0,j=nums.size()-1;
        while (i<j){
            if (!nums.get(i).equals(nums.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }*/
    //方法二:反转链表+快慢指针
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //1、找前半部分的结尾
        ListNode firstHalfEnd = endOfFirstHalf(head);
        //2、找后半部分的开始
        ListNode secondHalfStart = reverse(firstHalfEnd.next);

        //3、比较两个链表，判断是否相同
        ListNode preNode = head;//preNode 指向前半链表表头
        ListNode lastNode = secondHalfStart;//preNode 指向后半链表表头
        boolean res = true;
        while (res && lastNode != null) {
            if (preNode.val != lastNode.val) {
                res = false;
            }

            //往下走
            preNode = preNode.next;
            lastNode = lastNode.next;
        }
        //4、还原链表
        firstHalfEnd.next = reverse(secondHalfStart);
        return res;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    //反转链表
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
