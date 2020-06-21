package 数组与字符串.旋转数组;

/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
示例 1:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
 */
public class Solution {
    //方法一：增加额外数组，将下标为i的元素放到第(i+k)% n 的位置，然后把新数组拷贝到原数组中
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

    }

    //方法二：反转数组 三次反转
    /*
    假设 n=7 且 k=3。
    原始数组                  : 1 2 3 4 5 6 7
    反转所有数字后             : 7 6 5 4 3 2 1
    反转前 k 个数字后          : 5 6 7 4 3 2 1
    反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
    */

    /*public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }*/
}

