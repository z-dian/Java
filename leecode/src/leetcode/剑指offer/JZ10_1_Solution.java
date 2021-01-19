package leetcode.剑指offer;

/**
 * @author 张点
 * @description 斐波那契数列
 * @date 2020/10/14 13:38
 **/
public class JZ10_1_Solution {
    public int fib(int n) {
        int constant = 1000000007;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n; i++) {
            int sum = (first+second)%constant;
            first = second;
            second = sum;
        }
        return first;
    }
}
