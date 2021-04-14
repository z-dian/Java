package 华为机试;


import java.util.Scanner;

/**
 * Description: 从单向链表中删除指定值的节点
 * Created by zhang on 2021/3/24 9:44
 */
public class HJ48 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //链表总节点数
            int nodeNum = in.nextInt();
            ListNode head = null;//头节点
            ListNode curNode = null;//当前节点
            //构建链表
            for (int i = 0; i < nodeNum; i++) {
                if (i == 0) {//如果是第一个数直接就是头节点
                    head = new ListNode(in.nextInt(), null);
                    curNode = head;
                } else {//否则让当前节点指向头节点，从头节点开始构建链表
                    curNode = head;
                    int a = in.nextInt();//a是要插入的数
                    int b = in.nextInt();//b是a要找的数
                    while (curNode != null) {
                        if (curNode.next == null) {//如果到最后都没找到b，直接在末尾加入节点
                            curNode.next = new ListNode(a, null);
                            break;
                        } else if (curNode.val == b) {//如果找到b了且b不是最后一个节点，则在其后插入
                            curNode.next = new ListNode(a, curNode.next);
                            break;
                        } else {//未找到，当前节点后移继续找
                            curNode = curNode.next;
                        }
                    }
                }
            }
            //删除指定值的节点
            int deleteNode = in.nextInt();
            curNode = head;//重置curNode
            boolean isDelete = false;//是否找到删除节点
            if (head.val == deleteNode) {//如果要删除的节点是头节点，直接删除
                head = head.next;
                isDelete = true;
            } else {//如果不是头节点，则比较是否要删除
                while (curNode.next != null) {
                    if (curNode.next.val == deleteNode) {
                        curNode.next = curNode.next.next;
                        isDelete = true;
                        break;
                    }
                    curNode = curNode.next;
                }
            }
            if (isDelete) {//如果删除了，初始化curNode，遍历输出链表
                curNode = head;
                while (curNode != null) {
                    System.out.print(curNode.val + " ");
                    curNode = curNode.next;
                }
                System.out.println();
            }
        }
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
