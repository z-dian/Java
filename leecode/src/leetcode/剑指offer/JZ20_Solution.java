package leetcode.剑指offer;

/**
 * @author 张点
 * @description 表示数值的字符串：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、
 * "+-5"及"12e+5.4"都不是。
 * @date 2020/10/28 8:55
 **/
public class JZ20_Solution {
    public boolean isNumber(String s) {
        String trim = s.trim();
        if (trim == null || trim.length() == 0) return false;
        if (trim.length() == 1) {
            if (trim.charAt(0) < '0' || trim.charAt(0) > '9') {
                return false;
            }
        }
        boolean num = false, dot = false, hasE = false;
        for (int i = 0; i < trim.length(); i++) {
            if (trim.charAt(i) >= '0' && trim.charAt(i) <= '9') {
                num = true;
            } else if (trim.charAt(i) == 'e' || trim.charAt(i) == 'E') {
                if (hasE || i == 0 || !num) return false;//e只能出现一次，且之前必须出现数
                hasE = true;
                num = false;//重置sum，排除123e或者123e+的情况，确保e之后也出现数
            } else if (trim.charAt(i) == '+' || trim.charAt(i) == '-') {
                //+-符号只能出现在首位，或者跟在e之后
                if (i != 0 && trim.charAt(i - 1) != 'e' && trim.charAt(i - 1) != 'E') return false;
            } else if (trim.charAt(i) == '.') {
                //小数点不能出现在e之后，也不能出现两次
                if (dot || hasE) return false;
                dot = true;
            } else {//其他非法输入
                return false;
            }
        }
        return num;
    }
}
