package 除自身以外数组的乘积;

/*
给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
示例:
输入: [1,2,3,4]
输出: [24,12,8,6]
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
思路：
第一个for遍历计算当前元素左边的乘积
第二个for计算当前元素左积与右积的乘积
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] output = new Solution().productExceptSelf(nums);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]+" ");
        }

    }

    public int[] productExceptSelf(int[] nums) {
        //创建一个整数数组output[]
        int[] output = new int[nums.length];
        int p=1;
        for (int i = 0; i < output.length; i++) {
            output[i]=p;
            p*=nums[i];////前i位数的乘积
        }
        int q=1;
        for (int i = output.length-1; i >=0 ; i--) {
            output[i]*=q;//计算左积与右积的乘积
            q*=nums[i];//当前元素右边的乘积
        }
        return output;
    }
}
