package 动态规划.买卖股票的最佳时机二;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1:
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
示例 2:
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Solution {
    //将所有有差值的利润相加所得总和即为最大利润(贪心法)
   /* public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }*/
    /*//谷峰法
    public int maxProfit(int[] prices) {
        int i = 0;
        int maxProfit = 0;
        int peak = prices[0];
        int vally = prices[0];
        while (i < prices.length - 1) {
            //当第i天股价大于等于第i+1天时，说明股价是处于下跌状态，让i++，一直到股价跌到底
            if (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            //记录谷底的股价
            vally = prices[i];
            //当第i天的股价小于等于第i+1天时，说明股价处于上升阶段，让i++，一直到股价上升到顶峰
            if (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            //记录顶峰的股价值
            peak = prices[i];
            //此时出售，将顶峰与谷底的股价差值加到利润里去，得到最大利润。
            maxProfit += peak - vally;
        }
        return maxProfit;
    }*/
    //动态规划法：
    /*（1）定义状态：dp[i][j]
    i表示：索引为i的这一天能获得的最大利润；
    j表示：索引为i的这一天是否持股，0表示不持股，1表示持股
    （2）状态转移方程
    状态可以是不持股，一直到最后一天依然不持股，也就是说状态一直为0；
    每一天的状态可以转移，也可以不动。
    （3）确定初始值
    什么也不做：dp[0][0]=0;
    第一天就买股票，当前收益为负：dp[0][1]=-prices[0];
    (4)确定输出值
    dp[len-1][0]
    */
    /*public int maxProfit(int[] prices){
        int len = prices.length;
        if(len<2){
            return 0;
        }

        int[][] dp = new int[len][2];
        //初始值
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i <len ; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }*/
    //动态规划优化（使用两个滚动变量将一维数组状态压缩到常数）
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        //cash表示持有现金，hold表示持有股票
        int cash = 0;
        int hold = -prices[0];
        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            //持有现金的值为当前现金和持有股票加上抛售的第i天的股价值的最大值
            cash = Math.max(preCash, preHold + prices[i]);
            //股票值为当前持股值和买了第i天股票后持股的最大值
            hold = Math.max(preHold, preCash - prices[i]);
            //将当前现金和当前持股更新
            preCash = cash;
            preHold = hold;
        }
        return cash;
    }
}
