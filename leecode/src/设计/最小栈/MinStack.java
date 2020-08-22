package 设计.最小栈;

import java.util.Stack;

/*
题目描述：
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

思路：利用辅助栈，一个栈利用java自带的stack，保存正常入栈的值，另一个辅助栈去存最小值，也就是
用栈顶保存所有元素的最小值。
辅助栈的具体操作如下：
（1）将第一个元素入栈
（2）新加入的元素如果大于栈顶元素，不做任何操作
（3）如果新加入的元素小于等于栈顶元素，则将其入栈
（4）出栈元素不等于栈顶元素，不操作
（5）出栈元素等于栈顶元素，那么就将栈顶元素出栈

 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            minStack.push(node <= minStack.peek() ? node : minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
