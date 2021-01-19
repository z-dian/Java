package leetcode周赛.牛牛算数;

import java.util.Arrays;

/*
给你一个含有n个元素的数组arr[i]，请你告诉牛牛这个数组的中位数大还是平均数大，如果中位数更大输出1，
如果平均数更大输出-1，如果中位数和平均数相等输出0
 */
public class Solution {
    public int Answerofjudge(int[] arr) {
        // write code here
        long sum = 0;
        double mid, ave;
        for (int j : arr) {
            sum += j;
        }
        ave = sum / 1.0 / arr.length;
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            mid = (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
        } else {
            mid = arr[arr.length / 2];
        }
        return Double.compare(mid, ave);
    }

    public static void main(String[] args) {
        int[] arr = {6,6,6,6,5,8};
        int res = new Solution().Answerofjudge(arr);
        System.out.println(res);
    }
}
