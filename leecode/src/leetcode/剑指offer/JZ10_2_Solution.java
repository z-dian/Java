package leetcode.剑指offer;

/**
 * @author 张点
 * @description 青蛙跳台阶问题
 * @date 2020/10/16 13:42
 **/
public class JZ10_2_Solution {
    /*public int numWays(int n) {
        if(n<2)return 1;
        int a = 1,b = 1;
        for(int i = 0;i<n;i++){
            int sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }*/
    public int numWays(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
