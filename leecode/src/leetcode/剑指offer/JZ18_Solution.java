package leetcode.剑指offer;

/**
 * @author 张点
 * @description 删除链表的节点
 * @date 2020/10/26 8:21
 **/
public class JZ18_Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if(head.val==val)return head.next;
        ListNode currentNode = head;
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        while (currentNode != null && currentNode.val != val) {
            preNode = currentNode;
            currentNode = currentNode.next;

        }
        if(currentNode!=null){
            preNode.next=currentNode.next;
        }
        return head;
    }

}
