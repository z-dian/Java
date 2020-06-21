package 数组与字符串.最大回文子串;

/**
 * @Author zd
 * @Date 2019/12/9 18:19
 * @Description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
/*
示例 1：                         示例 2：
输入: "babad"                    输入: "cbbd"
输出: "bab"                      输出: "bb"
注意: "aba" 也是一个有效答案。

思路：
    中心扩展法：遍历每个索引，以当前索引为中心，利用“回文串”对称的特点，往两边扩散，看最多能扩散多远。
    这里要注意一个细节：回文串长度为奇数和偶数时，“回文中心”的形式不同：
        奇数回文串的“中心”是一个具体的字符，例如：回文串“aba”的中心字符是b；
        偶数回文串的“中心”是位于中间的两个字符的“空隙”，例如：回文串串 "abba" 的中心是两个 "b" 中间的那个“空隙”。
 */
public class Solution {
    public static void main(String[] args) {
        String s = "ba";
        String res = new Solution().longestPalindrome(s);
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen=1;
//        String res = s.substring(0,1);
        String res = s.substring(0,1);
        //中心位置枚举到 len - 2 即可,因为最后一个间隙的位置在len-2之后，索引0和len-1不用扩散，扩散不出去。
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s,i,i);
            String evenStr = centerSpread(s,i,i+1);
            String maxLenStr = oddStr.length()>evenStr.length()?oddStr:evenStr;
            if(maxLenStr.length()>maxLen){
                maxLen=maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    //中心扩展
    public String centerSpread(String s, int left, int right) {
        //left==right的时候，此时回文中心是一个字符，回文串的长度是奇数
        //left==right+1的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int length = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < length) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        //注意，当跳出循环时，恰好满足s.charAt(i) == s.charAt(j)，因此不能取i和j
        return s.substring(i + 1, j);
    }

}
