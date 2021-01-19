package leetcode.剑指offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 张点
 * @description 数组中重复的数字
 * @date 2020/10/9 11:38
 **/
public class JZ03_Solution {
    //普通方法
    /*public int findRepeatNumber(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        Arrays.sort(nums);
        int i = 0;
        for(int j = 1;j<nums.length;j++){
            if(nums[i++]==nums[j]){
                return nums[j];
            }
        }
        return -1;
    }*/

    //set方法
    /*public int findRepeatNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                return nums[i];
            } else {
                map.add(nums[i]);
            }
        }
        return -1;
    }*/

    //原地置换方法
    public int findRepeatNumber(int[] nums) {
        int i=0;
        while (i<nums.length){
            if(nums[i]==i){
                i++;
                continue;
            }
            if(nums[nums[i]]==nums[i]){
                return nums[i];
            }
            int temp = nums[i];
            nums[i]=nums[temp];
            nums[temp]=temp;
        }
        return -1;
    }

}
