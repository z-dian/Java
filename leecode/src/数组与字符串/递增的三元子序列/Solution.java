package 数组与字符串.递增的三元子序列;

/*
给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

数学表达式如下:

如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

示例 1:

输入: [1,2,3,4,5]
输出: true
示例 2:

输入: [5,4,3,2,1]
输出: false
 */
public class Solution {
    /*思路：min看做最小值，second看做第二元素最小的递增对的第二元素，那么算法的实质就是不断更新min和second而已。*/
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            //num比min小或相等，肯定不存在递增三元素。刷新的时候又不可能存在以num结尾的递增对，因此，只需要刷新min
            if (num <= min) {
                min = num;
            } else if (num <= second) {//num比second小或相等，肯定不存在递增三元素。由于存在以num结尾的递增对且num不大
                                        // 于second，因此可以更新second
                second = num;
            } else {//num比second大，那就存在递增三元素，因为second是一个递增对的第二元素，加上num后就是递增三元素了
                return true;
            }
        }
        return false;
    }
}
