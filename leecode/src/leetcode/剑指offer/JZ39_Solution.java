package leetcode.剑指offer;

import java.util.HashMap;

/**
 * @author 张点
 * @description 数组中出现的次数超过数组长度的一半，请找出这个数字。
 * @date 2020/11/18 10:58
 **/
public class JZ39_Solution {
    //map方法
    /*public int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > len / 2) {
                return nums[i];
            }
        }
        return 0;
    }*/
    //摩尔投票法
    public int majorityElement(int[] nums) {
        int moleVote = 0, res = nums[0];
        for (int i : nums) {
            if (moleVote == 0) {
                res = i;
            }
            moleVote += res == i ? 1 : -1;
        }
        return res;
    }
}
