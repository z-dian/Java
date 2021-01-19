package leetcode.剑指offer;

/**
 * Description: 求1+2+...+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * Created by zhang on 2021/1/5 9:32
 */
public class JZ64_Solution {
    int res = 0;
    public int sumNums(int n) {
        //逻辑短路，如果n>1成立，开启下一层递归sumNums(n-1)
        //如果n>1不成立（此时n=1），则终止递归
        //Java 中，为构成语句，需加一个辅助布尔量 x ，否则会报错
        //Java 中，开启递归函数需改写为 sumNums(n - 1) > 0 ，此整体作为一个布尔量输出，否则会报错
        //初始化变量 res 记录结果
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
    //简化版
    /*public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }*/
}
