package leetcode.剑指offer;
import java.util.Arrays;
/**
 * @author 张点
 * @description 扑克牌的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、
 * 小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * @date 2020/12/25 14:10
 **/
public class JZ61_Solution {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);//数组排序
        int zeroNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) zeroNum++;//统计大小王个数
            else if (nums[i] == nums[i + 1]) return false;//5张牌中若有重复则不可能顺子，故返回false
        }
        return nums[4] - nums[zeroNum] < 5;//最大值和最小值之差小于5则可构成顺子
    }

}
