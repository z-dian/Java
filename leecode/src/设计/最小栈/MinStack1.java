package 设计.最小栈;

import java.util.Stack;

/*
优化方法一：
只用一个栈实现，用一个变量min存储当前最小值，如果新来的元素比当前最小值还要小，则先将当前最小值入栈，
再讲新来的最小元素入栈，那么栈顶元素就是当前最小的元素。同时更新保min。
当出栈的时候，把当前栈顶元素出栈，然后再出栈一次，将第二次出栈的元素赋值给min。
 */
public class MinStack1 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        //当前值最小
        if (x <= min) {
            //将之前的最小值保存
            stack.push(min);
            //更新最小值
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        //如果弹出的值是最小值，那么将下一个元素更新为最小值。
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
