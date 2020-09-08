package 牛客.剑指offer;

/**
 * @ClassName JZ_Solution
 * @Description 连续子数组的最大和
 * @Author 张点
 * @Date 2020/8/31 9:36
 * @Version 1.0
 **/
public class JZ30_Solution {
    public int FindGreatestSumOfSubArray(int[] array) {

        int maxSum = array[0];//记录当前所有子数组的和的最大值
        int curSum = array[0];//记录包含array[i]在连续子数组和的最大值

        for(int i = 1 ;i<array.length;i++){
            curSum= Math.max(array[i],curSum+array[i]);
            maxSum=Math.max(maxSum,curSum);
        }

        return maxSum;
    }

}
