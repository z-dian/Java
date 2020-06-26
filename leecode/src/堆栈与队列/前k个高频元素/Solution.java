package 堆栈与队列.前k个高频元素;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 */
public class Solution {
    /*
    思路：
    1、借助哈希表存储元素和其出现的次数，遍历一遍统计元素出现的频率
    2、维护一个大小为k的最小堆
    3、每次都将新的元素与堆顶元素比较，如果新元素的频率比堆顶元素大，则弹出堆顶元素，将新元素添加进去
    4、最终堆中的k个元素就是前k个高频元素
    */
    public int[] topKFrequent(int[] nums, int k) {
        //借助哈希表存储元素和其出现的次数，遍历一遍统计元素出现的频率
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        //遍历count，用最小堆存储频率最大的k个元素
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int num : count.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        //取出最小堆的元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
