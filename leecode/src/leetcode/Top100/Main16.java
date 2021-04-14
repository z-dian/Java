package leetcode.Top100;

import java.util.Arrays;

/**
 * Description: 最接近的三数之和
 * Created by zhang on 2021/3/15 9:46
 */
public class Main16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int min = nums[i] + nums[start] + nums[start + 1];
                if (target < min) {
                    if (Math.abs(min - target) < Math.abs(res - target)) {
                        res = min;
                    }
                    break;
                }
                int max = nums[i] + nums[end] + nums[end - 1];
                if (target > max) {
                    if (Math.abs(target - max) < Math.abs(target - res)) {
                        res = max;
                    }
                    break;
                }
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) return sum;
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum > target) {
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else {
                    start++;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}
