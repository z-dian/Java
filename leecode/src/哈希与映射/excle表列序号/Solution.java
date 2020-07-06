package 哈希与映射.excle表列序号;

import java.util.HashMap;

/*
给定一个Excel表格中的列名称，返回其相应的列序号。
例如，
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
示例 1:
输入: "A"
输出: 1
示例 2:
输入: "AB"
输出: 28
示例 3:
输入: "ZY"
输出: 701
 */
public class Solution {
    /*public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        int mul = 1;
        for (int i = c.length-1; i >=0 ; i--) {
            res = res + mul*(c[i]-'A'+1);
            mul*=26;
        }
        return res;
    }*/
    public static int titleToNumber(String s){
        char[]  c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < c.length; i++) {
            res = res*26+(c[i]-'A'+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ABC";
        int res = titleToNumber(s);
        System.out.println(res);
    }
}

