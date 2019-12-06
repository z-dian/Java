package 两数相加;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        ListNode l1 = new ListNode(0);
        System.out.println("请输入L1:");
        while (sc1.hasNextInt()) {
            ListNode t = new ListNode(0);
            t.val = sc1.nextInt();
            t.next = l1;
            l1 = t;

        }
        sc1.close();

        System.out.println("请输入L2:");
        Scanner sc2 = new Scanner(System.in);
        ListNode l2 = new ListNode(0);
        while (sc2.hasNextInt()) {
            ListNode t = new ListNode(0);
            t.val = sc2.nextInt();
            t.next = l2;
            l2 = t;
        }
        sc2.close();
        addTwoNumber a = new addTwoNumber();
        ListNode l3 = a.addTwoNumber(l1, l2);

        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }

    }
}
