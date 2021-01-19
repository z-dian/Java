package leetcode.剑指offer;

/**
 * @author 张点
 * @description 两个链表的第一个公共节点
 * @date 2020/12/1 10:24
 **/
public class JZ52_Solution {
    //双指针法 La+Lb = Lb+La
    /*1.两链表相等的情况很简单，如果两链表不相等时，分别让pA和pB指向A,B链表的头部，同时遍历，
     当短一点的链表先被遍历到了末尾，就将该指针指向另一个链表的头结点；另一个链表也是如此。
    2.如果两个链表会相交，那么照步骤 1 遍历下去，两指针一定会在链表相交处相遇。
    如果两个链表不会相交，那么照步骤 1 遍历下去，两指针一定会同时走到 null处，从而退出循环然后返回 null（即两链表没有交点）。
    */
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null || pB != null) {
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }*/
    //让headA,headB长度相同时开始同时遍历
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        while (lenA!=lenB){
            if(lenA>lenB){
                headA=headA.next;
                lenA--;
            }else {
                headB=headB.next;
                lenB--;
            }
        }
        while (headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head!=null){
            head=head.next;
            length++;
        }
        return length;
    }
}
