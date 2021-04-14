package leetcode.经典算法;

import 数组与字符串.两数相加.Test;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Stack;
import java.util.logging.Level;

/**
 * Description: leecode
 * Created by zhang on 2021/3/26 10:52
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1, 4};
        int[] quickSort1 = new QuickSort1().sortArray(nums);
        System.out.println(Arrays.toString(quickSort1));
    }

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quicksort(int[] nums, int start, int end) {
        if (start > end) return;
        int i = start;
        int j = end;
        int tmp = nums[start];
        int t;
        while (i != j) {
            while (i < j && nums[j] >= tmp) {
                j--;
            }
            while (i < j && nums[i] <= tmp) {
                i++;
            }
            if (i < j) {
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[start] = nums[i];
        nums[i]  = tmp;
        quicksort(nums,start,i-1);
        quicksort(nums,i+1,end);
    }
}
