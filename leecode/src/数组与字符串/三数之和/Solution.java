package 三数之和;
/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

思路：
1、先对数组进行排序，排序后固定一个数nums[i],再让左指针指向nums[i]后面的两端，数字分别为nums[L]=num[i+1]和nums[R]=nums[len-1]，
计算nums[i]、nums[L]和nums[R]三者之和，若为0，则添加进结果集
2、如果nums[i]大于0，则三数之和必然大于0，结束循环
3、如果nums[i]==nums[i-1]，说明该数字重复，跳过
4、当sum == 0 时，nums[L]==nums[L+1]，则结果重复，跳过，让L++
5、当sum == 0 时，nums[R]==nums[R-1]，则结果重复，跳过，让R--
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = new ArrayList<>();
        ans = new Solution().threeSum(nums);
        System.out.println(ans.toString());

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        Arrays.sort(nums);//排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {//去重
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {//去重
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {//去重
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }
}
