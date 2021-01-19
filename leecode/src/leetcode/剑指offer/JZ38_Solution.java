package leetcode.剑指offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 张点
 * @description 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * @date 2020/11/17 9:39
 **/
public class JZ38_Solution {


    public static void main(String[] args) {
        String s = "abc";
        String[] ans = permutation(s);
        for(int i = 0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }

    public static String[] permutation(String s) {
        List<String> res = new LinkedList<>();
        char[] c;
        c = s.toCharArray();
        dfs(0, c, res);
        return res.toArray(new String[res.size()]);
    }

    static void dfs(int pos, char[] c, List<String> res) {
        if (pos == c.length - 1) {
            res.add(String.valueOf(c));//添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = pos; i < c.length; i++) {
            //如果出现重复字符跳过，视作一次剪枝
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, pos,c);//将c[i]固定在x位
            dfs(pos + 1, c, res);//开始固定第x+1位字符
            swap(i, pos,c);//恢复交换
        }
    }

    static void swap(int a, int b, char[] c) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

}
