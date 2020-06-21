package 数学与数字.只出现一次的数字;
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
 */
//思路：用一个数异或其他数，相同的数异或结果为0，0异或非0数结果为这个数本身。
public class Solution {
    public int singleNumber(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}
