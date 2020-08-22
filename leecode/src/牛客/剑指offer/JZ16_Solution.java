package 牛客.剑指offer;

/**
 * @ClassName JZ16_Solution
 * @Description 合并两个排序的链表
 * @Author 张点
 * @Date 2020/8/17 13:27
 * @Version 1.0
 **/
public class JZ16_Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null&&list2==null)return null;
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode head = new ListNode(-1);
        ListNode current = head;

        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                current.next=list1;
                list1=list1.next;
            }else {
               current.next=list2;
                list2=list2.next;
            }
            current = current.next;
        }
        if(list1==null){
            current.next=list2;
        }
        if(list2==null){
            current.next=list1;
        }
        return head.next;
    }
}
