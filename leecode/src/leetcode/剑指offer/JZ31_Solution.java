package leetcode.剑指offer;

import java.util.Stack;

/**
 * @author 张点
 * @description 栈的压入、弹出操作
 * @date 2020/11/5 8:59
 **/
public class JZ31_Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
