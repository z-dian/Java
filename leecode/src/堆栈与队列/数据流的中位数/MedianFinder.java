package 堆栈与队列.数据流的中位数;

import java.util.PriorityQueue;

/*
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
 */
public class MedianFinder {
    //将数据流分为低位和高位两部分
    private PriorityQueue<Integer> low ;//小顶堆，保存高位的数
    private PriorityQueue<Integer> high;//大顶堆，保存低位的数
    public MedianFinder() {
        low = new PriorityQueue<>();
        high = new PriorityQueue<>((x,y)->(y-x));//lambda表达式降序

    }

   /*
    当 m = n（即 N为 偶数）：需向 A 添加一个元素。实现方法：将新元素 num 插入至 B，再将 B堆顶元素插入至 A ；
    当 m ！=n（即 N为 奇数）：需向 B添加一个元素。实现方法：将新元素 num 插入至 A ，再将 A 堆顶元素插入至 B ；
    */
    public void addNum(int num) {
        if(low.size()!=high.size()){
            low.add(num);
            high.add(low.poll());
        }else {
            high.add(num);
            low.add(high.poll());
        }
    }

    public double findMedian() {
        if(low.size()!=high.size()){
            return low.peek();
        }else {
            return (low.peek()+high.peek())/2.0;
        }
    }
    
}
