package leetcode.剑指offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 张点
 * @description 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * @date 2020/12/23 15:18
 **/
public class JZ59_1_Solution {
    //暴力法
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)return new int[0];
        int left = 0, right = k - 1;
        int[] res = new int[nums.length - k + 1];
        int n = 0;
        while (right < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, nums[i]);
            }
            res[n++] = max;
            left++;
            right++;
        }
        return res;
    }*/
    //单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            //那么为了维持从大到小的原则，需将尾部元素弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            //不走while的话，说明我们正常在队列尾部添加元素
            queue.addLast(i);
            //如果滑动窗口已经略过了列队中头部的元素，则将头部元素弹出
            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }
            //看看窗口有没有形成，只有形成了大小为k的窗口
            if (i >= (k - 1)) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = new JZ59_1_Solution().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}
