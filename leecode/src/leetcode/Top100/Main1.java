package leetcode.Top100;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 两数之和
 * Created by zhang on 2021/2/22 17:12
 */
public class Main1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
