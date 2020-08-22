package 牛客.剑指offer;

import java.util.Stack;

/**
 * @ClassName JZ21_Solution
 * @Description 栈的压入、弹出序列
 * @Author 张点
 * @Date 2020/8/22 12:14
 * @Version 1.0
 **/
public class JZ21_Solution {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stackA = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stackA.push(pushA[i]);
             while (!stackA.isEmpty()&&stackA.peek() == popA[j]) {
                stackA.pop();
                j++;
            }
        }
        return stackA.isEmpty();
    }

    public static void main(String[] args) {
        int[] numA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(numA, popA));
    }
}
