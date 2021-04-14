package leetcode.经典算法;

import java.util.Arrays;

/**
 * Description: 快排
 * Created by zhang on 2021/3/23 9:49
 */
public class QuickSort {
    public int[] sortArray(int[] nums){
        quicksort(nums,0,nums.length-1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if (end-start>=1) {//[1]递归调用条件，当前数组区间多余1个数的时候才能排序，否则直接返回
            //[3]首先让中间元素归位，也就是ij相遇的时候所指向的下标，就是当前这个数排序以后所在的位置
            int i = start;
            int j = end;
            int tmp;

            //[5]重复上述代码，直到ij相遇位置
            while (i<j){
                //[4]ij倒腿

                //[4.1]先让j往前走,若j指向的数字比i指向的数字大时,即nums[j]>=nums[i]时,j一直往前走,前提是ij没碰头，即i<j
                while (i < j && nums[j] >= nums[i]) {
                    j--;
                }
                //[4.2]当上述循环退出的时候，要么是ij相遇了，要么是nums[j]<nums[i]了，后一种情况发生时，才需要元素互换
                if (i < j) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
                //[4.3]再让i变量向后走
                while (i < j && nums[i] <= nums[j]) {
                    i++;
                }
                //[4.4]当上述循环退出的时候，要么是ij相遇了，要么是nums[i]>nums[j]了，后一种情况发生时，才需要元素互换
                if (i < j) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
            //[6]当代码运行到这个位置时，此时ij已经相遇，此时以ij为中心，递归调用quicksort方法，对左右两区间分别进行排序即可
            int mid = i ;
            quicksort(nums,start,mid-1);//左侧递归调用
            quicksort(nums,mid+1,end);//右侧递归调用
        }else {//[2]递归调用出口//当待排序区间只有一个元素或者没有元素时，什么都不用做，直接返回
            return;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7,0,1,9,2,6,3,8,5,4};
        QuickSort qs = new QuickSort();
        qs.sortArray(array);
        System.out.println(Arrays.toString(array));
    }
}
