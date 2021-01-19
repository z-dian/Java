package leetcode周赛.简单的公式;

/**
 * @author 张点
 * @description 现在有3个数组a，b，c
 * a[1]=2,a[2]=6,对所有的n>=3,a[n] = 2*a[n-1] + 3*a[n-2]。
 * b[1]=7,b[2]=35,对所有的n>=3,b[n] = 3*b[n-1] + 10*b[n-2]。
 * 对所有的n>=1,有c[n] = a[n]*b[n]。
 * 现在给你一个正整数n,返回c[n]%1000000007的值。
 * 示例1
 * 输入  2
 * 返回值 210
 * 说明
 * a[2]=6,b[2]=35,c[2]=a[2]*b[2]=210。
 * 示例2
 * 输入  10
 * 返回值 207027484
 * @date 2020/11/24 21:52
 **/
public class Solution {
    /**
     * 返回c[n]%1000000007的值
     *
     * @param n long长整型 即题目中的n
     * @return int整型
     */
    public int Answerforcn(long n) {
        // write code here
        int mod = 1000000007;
        long ans = 14;
        long x = 15;
        n = n - 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x;
                ans %= mod;
            }
            x = (x * x) % mod;
            n = n >> 1;
        }
        return (int) ans;

    }
}
