package 牛客.剑指offer;

import java.util.Stack;

/**
 * @ClassName JZ5_Solution
 * @Description 两个栈实现队列
 * @Author 张点
 * @Date 2020/8/8 14:02
 * @Version 1.0
 **/
public class JZ5_Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //直接插入就行
        stack1.push(node);
    }

    public int pop() {
        //当要pop时，因为栈与队列顺序不同，需要先将stack1中的数移到stack2中
        //这样stack2中的数出栈顺序就与队列的出队顺序一致了
        //如果stack2为空，则将stack1的元素从stack1中pop出来push进stack2，然后再从stack2中pop
        //如果stack2不为空，直接pop stack2中元素

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
