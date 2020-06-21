package 设计.LRU缓存机制;

public class DoubleList {
    private Node head,tail;//头尾虚节点
    private int size;//链表元素数

    public DoubleList(){
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        size=0;
    }

    //在链表头部插入节点x
    public void addFirst(Node x){
        x.next=head.next;
        x.prev=head;
        head.next.prev=x;
        head.next=x;
        size++;
    }

    //删除链表中的x节点（x节点一定存在）
    public void remove(Node x){
        x.prev.next=x.next;
        x.next.prev=x.prev;
        size--;
    }

    //删除链表中最后一个节点，并返回该节点
    public Node removeLast(){
        if(tail.prev==head){
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    //返回链表长度
    public int size(){
        return size;
    }
}
