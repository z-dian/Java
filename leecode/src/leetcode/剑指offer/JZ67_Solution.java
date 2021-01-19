package leetcode.剑指offer;

/**
 * Description: 把字符串转换成整数
 * 示例1:
 * 输入: "42"
 * 输出: 42
 * 示例2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−2^31) 。
 * Created by zhang on 2021/1/9 12:38
 */
public class JZ67_Solution {
    /*
       1.首部空格，删除即可
       2.符号位处理：三种情况“+”、“-”、“无符号”，用一个变量保存符号位，返回前判断正负即可
       3.非数字字符，直接返回0
       4.数字字符处理：
                1.字符转数字：此数字的ascii码与0的ASCII码相减即可
                2.数字拼接：若从左向右遍历，设当前字符为c，当前位数字为x 数字结果为res,则 x = ascii(c)-ascii(0),res = res*10+x
    */
    public int strToInt(String str) {
        char[] s = str.trim().toCharArray();
        if (s.length == 0) return 0;
        int i = 1, sign = 1;
        //i记录索引位置，若i=1表示0号位置是符号位，否则数字位从0开始
        if (s[0] == '-') {
            sign = -1;
        } else if (s[i] != '+') {
            i = 0;
        }
        int res = 0, boundary = Integer.MAX_VALUE / 10;
        for (int j = i; j < s.length; j++) {
            if (s[j] > '9' || s[j] < '0') {
                break;
            }
            //两种情况：res*10>2147483650 越界；res = boundary,但是个位数位>7(8或9)也越界，直接加上符号返回
            if (res > boundary || res == boundary && s[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s[j] - '0');
        }
        return res * sign;
    }

    public static void main(String[] args) {
        String str = "-91283472332";
        int res = new JZ67_Solution().strToInt(str);
        System.out.println(res);
    }
}
