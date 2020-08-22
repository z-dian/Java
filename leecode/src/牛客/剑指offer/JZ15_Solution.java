package 牛客.剑指offer;

import java.util.Stack;

/**
 * @ClassName JZ15_Solution
 * @Description 反转链表
 * @Author 张点
 * @Date 2020/8/15 20:29
 * @Version 1.0
 **/
public class JZ15_Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null)return null;

        Stack<ListNode> stack = new Stack<>();
        while (head!=null&&head.next!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode newhead = stack.pop();
        ListNode res = newhead;

        while (!stack.isEmpty()){
            newhead.next=stack.peek();
            newhead=newhead.next;
            stack.pop();

        }
        newhead.next=null;
        return res;
    }
}
