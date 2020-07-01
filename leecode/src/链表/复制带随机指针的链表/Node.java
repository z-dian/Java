package 链表.复制带随机指针的链表;

public class Node {
    int val;
    Node next;
    Node random;

    public Node() {
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
