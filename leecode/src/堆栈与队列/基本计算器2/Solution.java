package 堆栈与队列.基本计算器2;

import java.util.LinkedList;
import java.util.Stack;

/*
实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
 */
/*
思路：
1、中缀转后缀
2、将后缀结果计算输出
具体规则为：
1.中缀转后缀：
- 数字直接输出到后缀表达式
- 栈为空时，遇到运算符，直接入栈
- 遇到运算符，弹出所有优先级大于或等于该运算符的栈顶元素，并将该运算符入栈
- 将栈中元素依次出栈

例如：表达式：3+2 * 2
遇到3，直接输出到后缀表达式中，栈中元素为空，结果为： 栈： 空； 后缀表达式：3
遇到符号“+”，入栈，结果为： 栈：+ ； 后缀表达式：3
遇到2，直接输出，结果为： 栈：+； 后缀表达式： 3 2
遇到乘号*，入栈，结果为： 栈： * + ；后缀表达式：3 2
遇到2，直接输出，结果为： 栈： * + ；后缀表达式：3 2 2
最后，将元素出栈：结果为：后缀表达式：3 2 2 * +

2.计算后缀：
- 遇到数字，入栈
- 遇到运算符，弹出栈顶两个元素，做运算，并将结果入栈
- 重复上述步骤，直到表达式最右端

例如上述得到的后缀表达式为 3 2 2 * +
3 2 2 都是数字，入栈，结果为：栈：2 2 3
遇到* 号， 2 2 出栈，并计算，2*2 = 4, 4入栈，结果为：栈：4 3 ，表达式还剩一个加号
遇到+ 号，栈顶两个元素出栈并运算，4 3 做加法，4+3 =7
后缀表达式空了，计算完毕，输出结果：7

 */
public class Solution {
    /*int start = 0;

    public int calculate(String s) {
        //遇到优先级高的先入栈，计算优先级高的
        Stack<Integer> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        start = 0;
        while (start < s.length()) {
            if (s.charAt(start) == ' ') {//空格
                start++;
            } else if (s.charAt(start) == '+' || s.charAt(start) == '-' || s.charAt(start) == '*' || s.charAt(start) == '/') {
                //遇到操作符，入栈
                op.push(s.charAt(start++));
            } else {
                int cur = getNum(s, start);//获取当前数字
                if (!op.empty() && (op.peek() == '*' || op.peek() == '/')) {//只计算乘除
                    char ch = op.pop();
                    int last = st.pop();
                    if (ch == '*') {
                        cur *= last;
                    } else if (ch == '/') {
                        cur = last/cur;
                    }
                }
                st.push(cur);
            }
        }
        int res = 0;
        while (!op.empty()) {//计算加减
            char ch = op.pop();
            int last = st.pop();
            if (ch == '-') {
                res += (-last);
            } else {
                res += last;
            }

        }
        res += (st.pop());//剩余第一个正数
        return res;
    }

    private int getNum(String s, int index) {
        //截取一段连续的数字
        int i = index + 1;
        for (; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';
            if (temp > 9 || temp < 0) {
                break;
            }
        }
        int res = Integer.valueOf(s.substring(index, i));
        start = i;
        return res;
    }*/
    public int calculate(String s) {
        s=s.trim();
        // 符号指针变量
        char sign='+';
        Stack<Integer> stack=new Stack();
        // 数字指针变量
        int num=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            // 注意一个用例，"2048"
            // 0也是数字啊，取不到就输出少一位了
            if(cur>='0'){
                //进位累加
                num=num*10-'0'+cur;
            }

            //这里不是else if的逻辑
            // 单测太重要了
            // 最后一位，比如3+2*2,或者不是数字，开始处理符号
            if( (cur!=' ' && cur<'0') || i==s.length()-1){
                //判断上一个符号
                // 开始处理符号
                switch(sign){
                    // 当前符号前的数字直接压栈
                    case '+': stack.push(num);
                        break;
                    // 当前符号前的数字取反压栈
                    case '-': stack.push(-num);
                        break;
                    // 栈顶数字出栈，与当前符号前的数字相乘，结果值压栈
                    case '*': stack.push(stack.pop()*num);
                        break;
                    // 栈顶数字出栈，除于当前符号前的数字，结果值压栈
                    case '/': stack.push(stack.pop()/num);
                        break;
                }

                //记录当前符号
                //这一步很关键
                sign=cur;
                // 数字清零
                num=0;
            }
        }

        //result
        int result=0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
