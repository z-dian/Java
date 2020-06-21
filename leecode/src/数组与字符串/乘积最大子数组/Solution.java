package 数组与字符串.乘积最大子数组;

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution {
    //解法一：
    /*
    有三种状态：
    一种是数组中所有元素全是正数，那么不用考虑其他，直接所有数相乘即为结果
    二种是数组中含有奇数个负数，那么再考虑从正序遍历到连乘至倒数第二个负数，或者倒序遍历至第一个负数之前。
    三种是数组中含有偶数个负数，负负得正，同第一种情况
     */
    /*public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int res = nums[0];
        //包含了所有数相乘的情况
        //奇数个负数 情况一

        for (int i = 0; i < nums.length; i++) {
            max *= nums[i];
            res = Math.max(max, res);
            //考虑到遇到某个数为0时，前面所有数乘积为0，只需把max置为1，继续开始即可
            if(nums[i]==0){
                max=1;
            }
        }
        //奇数个负数  情况二
        max = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            max *= nums[i];
            res = Math.max(res, max);
            //考虑到遇到某个数为0时，前面所有数乘积为0，只需把max置为1，继续开始即可
            if(nums[i]==0){
                max=1;
            }
        }
        return res;

    }*/

    /*解法二：动态规划
     定义一个数组dpMax[i]表示第i个元素结尾的子数组的乘积，乘积的最大值。
     dpMax[i]取值：
     1、当nums[i]>=0时，且dpMax[i-1]>0，dpMax[i]=dpMax[i-1]*nums[i]
     2、当nums[i]>=0时，且dpMax[i-1]<0，前面子数组的乘积为负数，乘一个正数的结果也是负数，所以dpMax[i]=nums[i]
     3、当 nums[i] < 0，此时如果前边累乘结果是一个很大的负数，和当前负数累乘的话就会变成一个更大的数。所以我们还需要一个数组
     dpMin 来记录以第 i 个元素的结尾的子数组，乘积最小的值。
       ·  当dpMax[i-1]>=0，前面的子数组的乘积为正数，乘一个负数的结果为负数，所以dpMax[i]=nums[i]
       ·  当dpMax[i-1]<0，前面的子数组的乘积为负数，再乘一个负数结果为正，所以dpMax[i]=dpMin[i-1]*nums[i]
     按上述分析，我们需要很多if-else 来判断不同的情况，我们注意到dpMax[i]的取值无非三种：dpMax[i-1]*nums[i]、dpMin[i-1]*nums[i]、nums[i]
     那么我们更新的时候就无需区分哪种情况，只需要求最大的值即可：
     dpMax[i]=max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i],nums[i]);
     同理dpMin[i]也一样:
     dpMin[i]=min(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i],nums[i]);
    */
    public int maxProduct(int[] nums) {
        /*if (nums.length == 0) {
            return 0;
        }
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;*/

        if (nums.length == 0) {
            return 0;
        }
        int dpMax = nums[0];

        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int preMax = max;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.max(preMax * nums[i], nums[i]));
            max = Math.max(max,preMax);
        }
        return max;
    }
}
