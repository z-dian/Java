package 设计.LRU缓存机制;

public class Node {
    public int key , val;
    public Node next,prev;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
