package leetcode.剑指offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 张点
 * @description 数组中数字出现的次数Ⅱ
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * @date 2020/12/16 21:54
 **/
public class JZ56_2_Solution {
    /*public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            int key = (int) it.next();
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }*/

    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];//java int 类型有32位，其中首位为符号位
        int res = 0;
        for (int num : nums) {
            int bitMask = 1;//初始化，不能和res一起初始化
            for (int i = 31; i >= 0; i--) {//bitSum[0]为符号位
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if ((num & bitMask) != 0) {
                    bitSum[i]++;
                }
                bitMask = bitMask << 1;//左移没有无符号、带符号的区别，都是在右侧补0
            }
        }
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res ^= bitSum[i] % 3;
        }
        return res;
    }
}
