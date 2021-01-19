package leetcode.剑指offer;

/**
 * Description: 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * Created by zhang on 2020/12/30 21:03
 */
public class JZ63_Solution {
    /*动态规划
    状态定义：设dp[i]为以price[i]为结尾的子数组的最大利润（以下简称前i日的最大利润）
    转移方程：由于题目限定 “买卖该股票一次” ，因此前 i 日最大利润 dp[i] 等于前 i−1 日最大利润 dp[i-1]和第 i 日卖出的最大利润中的最大值。
             dp[i]=max(dp[i-1],price[i]-min(price[0:i]))
    初始状态：dp[0]=0,第一天利润为0
    返回值：dp[n-1] n为dp列表长度
    优化：前 i 日的最低价格 min(prices[0:i]) 时间复杂度为 O(i)。而在遍历prices时，可以借助一个变量（
     记为成本 cost）每日更新最低价格。优化后的转移方程为：
    dp[i]=max(dp[i−1],prices[i]−min(cost,prices[i])
    由于 dp[i]只与 dp[i - 1], prices[i]prices[i] , cost相关，因此可使用一个变量（记为利润 profit）代替 dp列表。优化后的转移方程为：
        profit=max(profit,prices[i]−min(cost,prices[i])
    */

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
