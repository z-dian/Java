package 数组与字符串.有效的括号;

import java.util.Stack;

/*题目描述：
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
        示例 1:
            输入: "()"
            输出: true
        示例 2:
            输入: "()[]{}"
            输出: true
        示例 3:
            输入: "(]"
            输出: false
        示例 4:
            输入: "([)]"
            输出: false
        示例 5:
            输入: "{[]}"
            输出: true
思路：
括号是成对出现的，若将左括号全部入栈，遇到匹配的右括号再弹出栈，若是匹配的话，栈最后为空。
遍历字符串，若遇到左括号，将其压入栈中，当时右括号时，看栈是否为空，若是空直接返回，否则再看是否和栈顶元素匹配，
若匹配则出栈，若不匹配直接返回false。遍历完成后，若栈为空，则返回true，否则返回false
 */
public class Solution {
    public static void main(String[] args) {
        String s1 = "({)}";
        String s2 = "()";
        String s3 = "{(]}";
        String s4 = "(){}[]";
        System.out.println(new Solution().isValid(s1));
        System.out.println(new Solution().isValid(s2));
        System.out.println(new Solution().isValid(s3));
        System.out.println(new Solution().isValid(s4));

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character top = stack.peek();
                if ((top == '(' &&s.charAt(i)==')')||(top == '{' &&s.charAt(i)=='}')||(top == '[' &&s.charAt(i)==']')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
