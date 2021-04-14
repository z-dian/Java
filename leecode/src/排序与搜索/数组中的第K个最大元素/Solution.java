package 排序与搜索.数组中的第K个最大元素;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
题目：
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
思路：
1、（暴力法）先给数组排序，排序后输出第length-k个数
2、（堆排序）创建小顶堆，设置堆大小为k，将数组中的每个元素加入堆中，
    当堆中元素个数>k时，释放出堆顶元素，继续放入元素，直到数组中元素都加入堆中，
    这样堆顶元素就是数组中第K大的数
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //方法一：暴力法排序
        /*Arrays.QuickSort(nums);
        return nums[nums.length-k];*/
        //方法二：堆排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        /*for (int i = 0; i <nums.length ; i++) {
            queue.add(nums[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }*/
        for(int num:nums){
            queue.add(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
