package leetcode.剑指offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 张点
 * @description 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * @date 2020/12/17 12:21
 **/
public class JZ57_1_Solution {
    //对撞双指针
    /*public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }*/
    //哈希表法
    /*public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int num:nums){
            int temp = target-num;
            if(set.contains(temp)){
                return new int[]{num,temp};
            }
        }
        return new int[0];
    }*/
    //二分法
    /*public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1, temp = target - nums[i];
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == temp) return new int[]{nums[mid], nums[i]};
                else if (nums[mid] > temp) right = mid - 1;
                else if (nums[mid] < temp) left = mid + 1;
            }
        }
        return new int[]{};
    }*/
}
