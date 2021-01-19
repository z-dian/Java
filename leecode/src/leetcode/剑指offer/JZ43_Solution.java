package leetcode.剑指offer;

/**
 * @author 张点
 * @description 1~n整数中1出现的次数
 * @date 2020/11/20 12:27
 **/
public class JZ43_Solution {
    public int countDigitOne(int n) {
        return func(n);
    }

    private int func(int n) {
        if (n <= 0) return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return func(pow - 1) + last + 1 + func(last);
        } else {
            return pow + high * func(pow - 1) + func(last);
        }
    }
}
