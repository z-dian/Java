package leetcode.剑指offer;


/**
 * @author 张点
 * @description 从尾到头打印链表
 * @date 2020/10/11 14:04
 **/
public class JZ06_Solution {
    //栈
   /* public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        int[] res = new int[stack.size()];
        if (stack.size() == 0) {
            return res;
        }
        int count = 0;
        while (!stack.isEmpty()) {
            int temp = stack.peek();
            res[count++] = temp;
            stack.pop();
        }
        return res;
    }*/

    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node!=null){
            len++;
            node=node.next;
        }
//        node=head;
        int[] res = new int[len];
        for(int i = len-1;i>=0;i--){
            res[i]=head.val;
            head=head.next;
        }
        return res;
    }
}
