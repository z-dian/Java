package 排序与检索.摆动排序二;
/*
给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
示例 1:
输入: nums = [1, 5, 1, 1, 6, 4]
输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
示例 2:
输入: nums = [1, 3, 2, 2, 3, 1]
输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]

思路：
先将数组排序；
从中间位置切分，分为前半部分A和后半部分B；
将B穿插到A中，生成一个新数组。
需要注意的点有：
如果数组长度是奇数，则中间元素是属于前半部分；
由于数组元素可能重复，所以穿插后重复元素可能会相邻，此时不满足题意；因此需将前后部分分别倒序；
 */

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        //1.数组排序
        Arrays.sort(nums);
        int arr[] = new int[nums.length];
        //2.从中间位置切分
        int mid = nums.length / 2;
        //3.确定中间位置
        mid = nums.length % 2 == 0 ? mid - 1 : mid;
        //4.将前半部分倒序
        for (int i = mid; i >= 0; i--) {
            arr[mid - i] = nums[i];
        }
        //5.将后半部分倒序
        for (int i = nums.length - 1; i > mid; i--) {
            arr[nums.length - i + mid] = nums[i];
        }
        //6.将前半部分插空排好
        for (int i = 0; i <= mid; i++) {
            nums[2*i]=arr[i];
        }
        //7:将后半部分插入
        int j = 1;
        for (int i = 1; i < nums.length; i+=2) {
            nums[i] = arr[mid+(j++)];
        }
    }
}
