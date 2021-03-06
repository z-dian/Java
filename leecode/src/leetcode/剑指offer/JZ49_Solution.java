package leetcode.剑指offer;

/**
 * @author 张点
 * @description 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数
 * @date 2020/11/26 10:47
 **/
// 一个十分巧妙的动态规划问题
// 1.我们将前面求得的丑数记录下来，后面的丑数就是前面的丑数*2，*3，*5
// 2.但是问题来了，我怎么确定已知前面k-1个丑数，我怎么确定第k个丑数呢
// 3.采取用三个指针的方法，p2,p3,p5
// 4.index2指向的数字下一次永远*2，p3指向的数字下一次永远*3，p5指向的数字永远*5
// 5.我们从2*p2 3*p3 5*p5选取最小的一个数字，作为第k个丑数
// 6.如果第K个丑数==2*p2，也就是说前面0-p2个丑数*2不可能产生比第K个丑数更大的丑数了，所以p2++
// 7.p3,p5同理
// 8.返回第n个丑数

public class JZ49_Solution {
    public int nthUglyNumber(int n) {
        int two = 0, three = 0, five = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[two] * 2, Math.min(dp[three] * 3, dp[five] * 5));
            if (dp[i] == dp[two] * 2) two++;
            if (dp[i] == dp[three] * 3) three++;
            if (dp[i] == dp[five] * 5) five++;
        }
        return dp[n - 1];
    }
}
