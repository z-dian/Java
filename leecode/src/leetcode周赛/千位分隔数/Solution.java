package leetcode周赛.千位分隔数;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 张点
 * @Date 2020/8/28 16:17
 * @Version 1.0
 **/
/*
给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
示例 1：

输入：n = 987
输出："987"
示例 2：

输入：n = 1234
输出："1.234"
示例 3：

输入：n = 123456789
输出："123.456.789"
示例 4：

输入：n = 0
输出："0"
 */
public class Solution {
    public static String thousandSeparator(int n) {
        StringBuilder str1 = new StringBuilder();
        while (n != 0) {
            int temp = n % 10;
            n = n / 10;
            str1.append(temp);
        }

        if (str1.length() == 0) {
            return "0";
        }
        int cnt = 0;
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            str2.append(str1.charAt(i));
            cnt++;
            if (cnt % 3 == 0 && cnt != str1.length()) {
                str2.append(".");
            }
        }
        StringBuilder str3 = new StringBuilder();
        for (int i = str2.length()-1; i >= 0; i--) {
            str3.append(str2.charAt(i));
        }
        return str3.toString();
    }

    public static void main(String[] args) {
        String s = thousandSeparator(1234);
        System.out.println(s);
    }
}
