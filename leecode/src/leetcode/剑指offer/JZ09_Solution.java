package leetcode.剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 张点
 * @description 用两个栈实现队列
 * @date 2020/10/13 11:58
 **/
public class JZ09_Solution {

    Deque<Integer> s1;
    Deque<Integer> s2;

    public JZ09_Solution() {
        s1 = new LinkedList<Integer>();
        s2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        if(s2.isEmpty()){
            return -1;
        }else {
            return s2.pop();
        }
    }
}
