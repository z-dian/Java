package 设计.LRU缓存机制;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
题目描述：
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，
则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，
从而为新的数据值留出空间。
思路：要让put 和 get 方法的时间复杂度为O(1)，我们可以总结出cache这个数据结构必要的条件：
查找快，插入快，删除快，有顺序之分。
哈希表查找快，但是无顺序之分，链表有顺序之分，插入删除快，但查找慢，所以结合哈希表和链表。所以选择
哈希链表。

 */
public class LRUCache {
    private HashMap<Integer,Node> map;
    private DoubleList cache;
    //最大容量
    private int cap;

    public LRUCache(int capacity){
        this.cap=capacity;
        map=new HashMap<>();
        cache=new DoubleList();
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).val;
        //利用put方法将该数据提前
        put(key,val);
        return val;
    }
    public void put(int key,int value){
        //先创建x节点
        Node x = new Node(key,value);

        if(map.containsKey(key)){
            //删除旧节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            //更新map中对应的数据
            map.put(key,x);
        }else {
            if(cap==cache.size()){
                //删除最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            //直接添加到头部
            cache.addFirst(x);
            map.put(key,x);
        }
    }
}
