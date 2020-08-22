package 牛客.剑指offer;

/**
 * @ClassName JZ8_Solution
 * @Description 跳台阶
 * @Author 张点
 * @Date 2020/8/10 13:36
 * @Version 1.0
 **/
/*
动态规划思想：
    target=1时，往上跳一层，只有一种方法
    target=2时，往上跳一层，跳两次，或者往上跳两层，只有2种方法
    target=3时，往上连续跳一层3次，跳1再跳2，跳2再跳一。
    分析：跳到target层，可以是target前一层跳一层到target，也可以前两层跳2层到target
    dp[i] = dp[i-1]+dp[i-2]
 */
public class JZ8_Solution {
    public int JumpFloor(int target) {
        if(target==1)return 1;
        int[] dp = new int[target+1];
        dp[1]=1;
        dp[2]=2;
        for(int i = 3;i<=target;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
}
