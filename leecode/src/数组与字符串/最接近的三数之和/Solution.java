package 最接近的三数之和;

import java.util.Arrays;

/*
问题描述：
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

思路：先给数组排序，然后固定一个元素，再利用双指针去寻找另外两个元素
1、利用Arrays.sort(nums)对数组进行排序
2、初始化一个保存结果的值result = nums[0]+nums[1]+nums[2]
3、利用下标i对数组进行遍历，此时就是在固定第一个元素。注意：下标i的边界为i < nums.length-2，否则会出现数组越界
4、每次遍历设两个指针，分别是left = i+1、right = nums.length-1
5、
 */
public class Solution {
    public static void main(String[] args) {
        int nums[] = {0, 0, 0};
        int target = 1;
        System.out.println("结果为：" + new Solution().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //初始化结果
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                //判断最小值min
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    //min 更接近target，更新结果result
                    if (Math.abs(min - target) < Math.abs(result - target)) {
                        result = min;
                    }
                    break;
                }
                //判断最大值max
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    //max 更接近target，更新结果result
                    if (Math.abs(max - target) < Math.abs(result - target)) {
                        result = max;
                    }
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target)
                    return sum;
                //sum 更接近target，更新结果result
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if (sum > target) {
                    right--;
                    //解决nums[right]重复
                    while (left != right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    //解决nums[left]重复
                    while (left != right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }

            }
            //解决nums[i]重复
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
