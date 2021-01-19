package leetcode.剑指offer;

/**
 * @author 张点
 * @description 打印从1到最大的n位数
 * @date 2020/10/24 12:46
 **/
public class JZ17_Solution {
    public int[] printNumbers(int n) {
        int nums = (int) Math.pow(10, n);
        int[] res = new int[nums-1];
        int j = 0;
        for (int i = 1; i < nums; i++) {
            res[j++] = i;
        }
        return res;
    }
}
