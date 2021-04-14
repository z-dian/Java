package leetcode.Top100;
/**
 * @description 删除链表的倒数第N个节点
 * @author 张点
 * @date 2020/10/18 16:01
 **/
public class Main19 {
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        int len = getLength(head);
        ListNode cur = dummy;
        for(int i = 0;i<len-n+1;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head!=null){
            len++;
            head = head.next;
        }
        return len;
    }*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //dummy是head的前驱结点
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        //pre指向要删除的前一个结点
        ListNode pre = dummy;
        //快慢指针找出要删除的结点
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            pre = pre.next;
            slow=slow.next;
            fast= fast.next;
        }
        pre.next=pre.next.next;
        return dummy.next;
    }
}
