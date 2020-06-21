package 数组与字符串.打乱数组;
/*
打乱一个没有重复元素的数组。
示例:
// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 */

import java.util.Random;

public class Solution {
    /*
        思路：设置一个随机数，遍历数组，让当前下标的元素和生成的随机数下标的元素交换;
        注意：随机数的范围为当前下标到数组最后一个元素下标
     */
    int[] array;
    int[] original;

    Random random = new Random();

    public int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
