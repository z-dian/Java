package 牛客.剑指offer;

/**
 * @ClassName JZ10_Solution
 * @Description 矩形覆盖
 * @Author 张点
 * @Date 2020/8/11 14:01
 * @Version 1.0
 **/
public class JZ10_Solution {
    //斐波那契数列
    /*public int RectCover(int target) {
        if(target==0)return 0;
        if(target==1)return 1;
        int first=0;
        int second =1;
        int fi = 0;
        for(int i = 2;i<=target;i++){
            fi=first+second;
            first=second;
            second=fi;
        }
        return  fi;
    }*/

    //动态规划
    public int RectCover(int target) {

        if (target <= 2) return target;
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    //递归，很耗时
    /*public int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }*/
}
