package 牛客.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName JZ3_Solution
 * @Description 从头到尾打印链表：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author 张点
 * @Date 2020/8/6 12:28
 * @Version 1.0
 **/
/*public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class JZ3_Solution {
    public  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) return res;

        ListNode node = listNode;
        Stack<Integer> stack = new Stack<>();
        while (node!=null&& node.next != null) {
            stack.push(node.val);
            node = node.next;
        }
        stack.push(node.val);
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

}
