package leetcode.剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 张点
 * @description 数组中数字出现的次数Ⅰ
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @date 2020/12/7 12:04
 **/
public class JZ56_1_Solution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;//所有数字异或的结果
        int a = 0, b = 0;
        for (int num : nums) {
            res ^= num;
        }
        //找第一个为不为0的数位
        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }

        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
