package leetcode.Top100;

/**
 * Description: 两数相加
 * Created by zhang on 2021/2/22 17:12
 */
public class Main2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int c = 0;
        while(l1!=null||l2!=null){
            int x = l1 == null?0:l1.val;
            int y = l2 == null?0:l2.val;
            int sum = x+y+c;
            c = sum/10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            if(c == 1){
                cur.next = new ListNode(c);
            }
        }
        return pre.next;
    }
}
