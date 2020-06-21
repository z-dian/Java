package 动态规划.买卖股票的最佳时机;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票。
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，
最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Solution {
    //暴力法：
    /*public int maxProfit(int prices[]) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = 1; j < prices.length; j++){
                int profit = prices[j]-prices[i];
                if(profit>maxProfit){
                    maxProfit=profit;
                }
            }
        }
        return maxProfit;
    }*/
    //一次遍历(贪心算法)
    /* public int maxProfit(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }*/
    /*动态规划：
    （1）设定状态：dp[i][j]
    dp[i][j]表示：在索引为i的这一天，用户手上持股状态为j所获得的最大利润
    j只有两个值：0表示不持股（特指卖出股票后不持股的状态）；1表示持股
    “用户手上不持股”不代表用户一定在索引为i这一天把股票抛售了
    （2）状态转移方程：
    dp[i][0]怎么转移？
        dp[i-1][0]:索引为i的昨天用户不持股，什么也不做；
        dp[i-1][1]+prices[i]:昨天持股，在今天抛售股票，状态由1变为0，此时卖出股票，
        因此加上这一天的股价
    综上：dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);
    dp[i][1]怎么来的？
        dp[i-1][1]:用户昨天持股，今天什么也不操作；
        -prices[i]:注意：状态1不能由状态0而来，因为事实上，状态0特指：“卖出股票后手上不持股
        的状态”，请注意这个状态和“没有进行任何一次交易手上不持股状态”的区别。
        因此-prices[i]表示在索引为i的这一天买入股票得到的利润。注意：因为只能交易一次，
        所以不能加上dp[i-1][0]。
    综上：dp[i][1]=max(dp[i-1][1],-prices[i])
    （3）考虑初值
    在第0天不持股：dp[0][0]=0;
    在第0天持股：dp[0][1]=-prices[0]。
    （4）考虑输出
    从状态转移方程可以看出，每一天的状态都考虑了之前的状态，在只发生一次交易的情况下，手上持股，
    并不能使我们获利，故输出只能是dp[len-1][0]，而不是dp[len-1][1]。
    */
    public int maxProfit(int prices[]) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int dp[][] = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

}
