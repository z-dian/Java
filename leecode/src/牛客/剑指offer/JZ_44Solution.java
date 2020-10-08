package 牛客.剑指offer;

import java.util.Stack;

/**
 * @description 翻转单词顺序列
 * @author 张点
 * @date 2020/9/23 15:28
 **/
public class JZ_44Solution {
    public static String ReverseSentence(String str) {
        if(str==null||str.length()==0){
            return str;
        }
        if(str.trim().length()==0)return str;
        Stack<String> stack = new Stack<>();
        String[] s = str.split(" ");
        for(int i  = 0 ;i<s.length;i++){
            stack.push(s[i]);
        }
        StringBuilder res= new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.peek());
            stack.pop();
            if(!stack.isEmpty()){
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = ReverseSentence(" ");
        System.out.println(s);
        System.out.println(s.length());
    }
}
