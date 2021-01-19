package leetcode.剑指offer;

import java.util.Stack;

/**
 * @author 张点
 * @description 包含min函数的栈
 * @date 2020/11/4 10:19
 **/
public class JZ30_Solution {

    Stack<Integer> A, B;

    public JZ30_Solution() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
