package leetcode.Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 三数之和
 * Created by zhang on 2021/3/11 10:42
 */
public class Main15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //声明结果list
        List<List<Integer>> res = new ArrayList<>();
        //特判
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);//排序
        //遍历每一位数字
        for (int i = 0; i < nums.length; i++) {
            //因为数组已经排序好了，如果当前数字大于0，那么后面的数肯定大于当前数，那么他们的和肯定也大于0，直接break
            if (nums[i] > 0) break;
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //设置双指针，分别指向当前数字后一位和最后一位
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                //计算当前数字与双指针指向的数之和，与0比较，分三种情况：
                int sum = nums[i] + nums[left] + nums[right];
                //第一种：三数之和小于0，说明需要更大的数字加进来才有可能满足三数之和等于0，所以移动双指针中较小的数
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    //第二种：三数之和大于0，说明需要更小的数字加进来才有可能满足三数之和等于0，所以移动双指针中较大的数
                    right--;
                } else {
                    //第三种：三数之和等于0，将这三个数加入到集合中，并将这个结果加入到最后的集合中
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    //为避免结果集重复，去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    //为避免结果集重复，去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //得到一个结果集后，分别移动双指针，计算剩下的中间的数有无满足该情况的
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
