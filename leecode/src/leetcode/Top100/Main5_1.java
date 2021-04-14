package leetcode.Top100;

/**
 * Description: 最长回文子串
 * Created by zhang on 2021/3/2 9:14
 */
public class Main5_1 {
    //动态规划
    public String longestPalindrome(String s) {
        //特判
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        //dp[i][j]表示s[i...j]是回文子串，这里s[i...j]定义为左闭右闭区间，s[i]s[j]都可以取到
        //1、定义状态
        boolean[][] dp = new boolean[len][len];
        /*
        2、思考状态转移方程
        一个回文串去掉头尾之后仍是回文串
        分类讨论：
        1.如果一个字符串头尾两个字符不相等，那么这个字符串就不是回文串
        2.如果一个字符串头尾两个字符相等，才有必要继续判断下去：
            ·如果里面的子串是回文，那么整体就是回文
            ·如果里面的子串不是回文，那么整体就不是回文
        即：在头尾字符相等的情况下，里面子串的回文性质据定了整个子串的回文性质，这就是状态转移。
        根据以上分析：转移方程为：dp[i][j] = (s[i]==s[j]) && dp[i+1][j-1]
        边界条件：表达式[i+1][j-1]不构成区间，即长度严格小于2，即(j-1)-(i+1)+1 < 2 ==> j-i<3
        也就是说j-i+1 长度为2或者3时，判断头尾两个字符是否相等就可以直接下结论了。
        */
        //3、初始化：单个字符一定是回文串，因此把对角线先初始化为true 即dp[i][i] = true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //4、考虑输出
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //只要dp[i][j] = true 成立，就表示子串s[i...j]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
