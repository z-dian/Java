package 牛客.剑指offer;

/**
 * @ClassName JZ14_Solution
 * @Description 链表中倒数第k个节点
 * @Author 张点
 * @Date 2020/8/14 22:10
 * @Version 1.0
 **/
public class JZ14_Solution {
    /*public static ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k==0)return null;
        Stack<ListNode> stack = new Stack<>();

        ListNode res = null;
        int count = 0;
        while (head!=null){
            stack.push(head);
            head=head.next;
            count++;
        }
        if(count<k){
            return null;
        }
        for(int i =0;i<k;i++){
            res = stack.pop();
        }

        return res;
    }*/

/*
快慢指针法，另快指针先走k步，然后快慢指针再同时走，快指针到链表尾部后，慢指针所指向的节点就是倒数第k个
 */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k==0)return null;
        ListNode fast = head;
        ListNode slow = head;
        while (k>0){
            if(fast==null){
                return null;
            }
            fast=fast.next;
            k--;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode head = null;
        int i = 5;
        while (i>0) {
            ListNode node = new ListNode(i);
            node.next = head;
            head = node;
            i--;
        }
        ListNode res  = FindKthToTail(head,1);
        System.out.println(res.val);

    }

}
