package leetcode.剑指offer;

import java.util.ArrayList;

/*
 * @Author 张点
 * @Description 圆圈中最后剩下的数字
0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
示例 1：
输入: n = 5, m = 3
输出:3
示例 2：
输入: n = 10, m = 17
输出:2
 * @Date 2020/12/28
 **/
public class JZ62_Solution {
    //经典约瑟夫环问题
    /*public int lastRemaining(int n, int m) {
        //环形链表-->ArrayList模拟:耗时
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }*/
    public int lastRemaining(int n, int m) {
        //递归
        int pos = 0;//最终活下来的人的初始位置
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }
}
