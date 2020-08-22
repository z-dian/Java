package 牛客.剑指offer;

import java.util.Stack;

/**
 * @ClassName JZ20_Solution
 * @Description 包含min函数的栈
 * @Author 张点
 * @Date 2020/8/20 14:18
 * @Version 1.0
 **/
public class JZ20_Solution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(!stack.isEmpty()){
            int top = minStack.peek();
            if(node<=top){
                minStack.push(node);
            }
        }else {
            minStack.push(node);
        }
    }

    public void pop() {
        int top = stack.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }

    }

    public int top() {
        if(stack.isEmpty()){
           return -1;
        }
        return stack.peek();
    }

    public int min() {

        return minStack.peek();
    }
}
