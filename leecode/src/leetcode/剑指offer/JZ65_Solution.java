package leetcode.剑指offer;

/**
 * Description: 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * Created by zhang on 2021/1/5 9:55
 */
public class JZ65_Solution {
    public int add(int a, int b) {
        while (b != 0) {//当进位为0时跳出循环
            int c = (a & b) << 1;//c表示进位
            a = a^b;//a^b表示非进位和
            b = c; //b表示进位
        }
        return a;
    }

    public static void main(String[] args) {
        int a = -3, b = 5;
        System.out.println(new JZ65_Solution().add(a,b));
    }
}
