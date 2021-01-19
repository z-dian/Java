package leetcode.剑指offer;

/**
 * @author 张点
 * @description 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * @date 2020/11/20 10:39
 **/
public class JZ42_Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
