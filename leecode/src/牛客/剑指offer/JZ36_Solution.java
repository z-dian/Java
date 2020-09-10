package 牛客.剑指offer;

import java.util.HashMap;

/**
 * @author 张点
 * @description 两个链表的第一个公共节点
 * @date 2020/9/9 9:23
 **/
public class JZ36_Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;

        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashMap.containsKey(current2))
                return current2;
            current2 = current2.next;
        }
        return null;
    }
}
