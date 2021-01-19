package leetcode.剑指offer;
/**
 * @author 张点
 * @description 在排序数组中查找数字Ⅰ
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * @date 2020/12/2 10:25
 **/
public class JZ53_1_Solution {
    public int search(int[] nums, int target) {
        //因为数组里都是整数，且有序，所以直接返回目标值减1与目标值下标之间的距离即为目标值出现的次数。
        return binarysearch(nums, target) - binarysearch(nums, target - 1);
    }

    private int binarysearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        //返回的是二分查找的目标值的右边界下标
        return i;
    }
    /*int cnt = 0;    // 计数器count

    public int search(int[] nums, int target) {
        // 初始化low = 0, high = nums.length - 1
        helper(nums, target, 0, nums.length - 1);
        return cnt;
    }

    // 根据算法设计分3种情况
    public void helper(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = (high - low) / 2 + low;
            //可能左右两边还有target重复的值，继续递归
            if (nums[mid] == target) {
                cnt++;      // 计数一次
                helper(nums, target, low, mid - 1);
                helper(nums, target, mid + 1, high);
            } else if (nums[mid] > target) {
                helper(nums, target, low, mid - 1);
            } else {
                helper(nums, target, mid + 1, high);
            }
        }
    }*/
}
