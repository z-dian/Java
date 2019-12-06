package 两数相加;

/*
思路：
1、将两个链表看成是长度相同的链表进行遍历，如果一个链表较短则在前面补0，比如：987+023=1010
2、每一个进行相加，同时考虑进位，当前位计算完毕后更新进位值
3、如果两个链表都遍历完毕，进位值为1，则在新链表最前方添加节点1

小技巧：对于链表，返回结果为头结点，通常需要初始化一个预先指针pre，该节点的下一个节点为真正的头节点head。
使用预先指针的目的是在与链表初始化时无可用节点值，而且链表构造过程中需要指针移动，进而导致头结点丢失，无法返回结果
 */
public class addTwoNumber {
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);//设置预先指针pre
        ListNode curr = pre;//创建一个负责移动的指针curr
        int carry = 0;//进位
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;//读取l1链表的当前节点
            int y = l2 == null ? 0 : l2.val;//读取l2链表的当前节点

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }
}
