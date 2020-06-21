package 数组与字符串.两数之和;
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]

 */

import java.util.HashMap;

/**
 * @Author zd
 * @Date 2019/12/7 16:52
 * @Description
 */
public class Solution {
    //方法一：暴力法
    /*public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] index=new int[2];
        for (int i = 0; i < length; i++){
            for(int j = i+1;j<length;j++){
                if(nums[i]+nums[j]==target){
                   return new int[] {i,j};
                }
            }
        }

        return index;

    }*/

    //方法二：哈希表
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.get(dif) != null) {
                index[0] = map.get(dif);
                index[1] = i;
                return index;
            }
            map.put(nums[i], i);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target = 26;
        Solution solution=new Solution();
        int[] index = solution.twoSum(nums,target);
        System.out.print("[");
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i]);
            if(i!=index.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
