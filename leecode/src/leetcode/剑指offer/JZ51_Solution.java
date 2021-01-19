package leetcode.剑指offer;

/**
 * @author 张点
 * @description 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，
 * 求出这个数组中的逆序对的总数。
 * @date 2020/11/30 9:29
 **/
public class JZ51_Solution {
    //暴力法：超时
    /*public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length;j++) {
                if (nums[j] > nums[i]) {
                    cnt++;
                } else {
                    continue;
                }
            }
        }
        return cnt;
    }*/
    int cnt;//统计逆序对的个数

    public int reversePairs(int[] nums) {
        if (nums.length != 0) {
            divide(nums, 0, nums.length - 1);
        }
        return cnt;
    }

    private void divide(int[] nums, int start, int end) {
        //递归终止
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;

        //分
        divide(nums, start, mid);
        divide(nums, mid + 1, end);
        //治
        merge(nums, start, mid, end);

    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];//辅助数组
        int i = start, j = mid + 1, k = 0;//i,j为两个指向分数组首地址的指针
        while (i <= mid && j <= end) {
            //若前面小于后面，直接存进去，并且移动前面数所在的数组的指针即可
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                //nums[i]>nums[j]了，从nums[i]到nums[mid]必定都大于nums[j]，因为已经分好的两边是有序的
                cnt += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (k = 0; k < temp.length; k++) {
            nums[start + k] = temp[k];
        }
    }
}
