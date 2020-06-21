package 动态规划.不同路径;

import java.util.Arrays;

/*
题目描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
动态规划：
（1）状态定义dp[i][j]表示到达i，j最多的路径:i表示从上面来的路径，j表示从左边来的路径。
（2）状态方程：dp[i][j]=dp[i-1][j]+dp[i][j-1];
（3）初值：第一行dp[0][j]=1，第一列dp[i][0]=1
 */
public class Solution {
    /*public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一行初始化，由于在边界，其值只能为1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一列初始化，由于在边界，其值只能为1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }*/
    //优化(滚动数组)
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
