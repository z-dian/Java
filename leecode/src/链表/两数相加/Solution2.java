package 链表.两数相加;
import 数组与字符串.两数相加.ListNode;
/*
题目描述：
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 【逆序】 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){//因为l1是基准链表，要是l1到尾部了，l2就算还有，直接返回l2的剩余部分
            return l2;
        }
        if(l2==null){//这里l2到尾部了，l1需要进行判断，尾部是否大于10，要去进位。
            //比如l1:9,9 .l2:9 一次运算过后l2到尾部,l1变为8,10,这时候依然当做l2有个0去进位
            if(l1.val>=10){
                l2 = new ListNode(0);
                l2.next = null;
            }else{
                return l1;
            }

        }

        int temp = l1.val+l2.val;
        l1.val = temp%10;
        if(temp>=10){  //说明l1应该进位
            if(l1.next==null){//要是l1没有下一位，则new一个节点进行连接
                l1.next = new ListNode(1);
            }else{
                l1.next.val++; //l1有下一个节点，直接下一个节点的值加一
            }
        }

        l1.next = addTwoNumbers(l1.next,l2.next);//用于重新连接携带新的值的每个l1节点

        return l1;
    }
}