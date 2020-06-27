package 堆栈与队列.滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;

/*
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
 i
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
public class Solution {
    //暴力法：两次循环，每次都找到滑动窗口的最大值
   /* public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        int res[] = new int[n - k + 1];
        for (int i = 0; i < res.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            res[i] = max;
        }
        return res;
    }*/

    /*//双端队列：头、尾、尾、头
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;
        int[] res = new int[n - k + 1];

        //dq里存的是数组的index，不是数组的值
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            //step1:头：移除头部，保证窗口的长度范围
            if (!dq.isEmpty() && dq.getFirst() < (i - k + 1)) {
                dq.removeFirst();
            }
            //step2:尾：移除尾部小于当前值的元素，原理参考篮球队长模型，去除不可能的元素
            while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                dq.removeLast();
            }
            //step3:尾：尾部加入，滑动窗口向右扩充
            dq.addLast(i);

            //step4:头：从头部返回最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return res;
    }*/


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int maxIndex = -1;
        int j = 0;
        for(int i = 0; i <= nums.length - k; i++){
            //判断最大值元素下标是否还在滑动窗口中
            if(i <= maxIndex && maxIndex < i + k){
                //如果当前最大值小于滑动窗口最右边的值，则更新最大值下标
                if(nums[maxIndex] <= nums[i+k-1]){
                    maxIndex = i+k-1;
                }
            } else {//在当前窗口查找、比较是否出现比当前最大值更大的数，若出现，则更新最大值下标，并将其加入结果集
                maxIndex = i;
                for(int m = i; m <= i + k -1; m++){
                    if(nums[maxIndex] < nums[m]) maxIndex = m;
                }
            }
            ans[j++] = nums[maxIndex];
        }
        return ans;
    }
}
