package 回溯算法.括号生成;

import java.util.ArrayList;
import java.util.List;

/*
题目描述：
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

思路：深度优先遍历
画树形结构图：
1、当前左右括号都大于0个可以使用的时候，才产生分支
    注意：可以生出左分支的条件：左括号剩余数量严格大于0；
          可以生出右分支的条件：左括号剩余数量严格小于右分支剩余数量。
2、产生左分支的时候，只看当前是否有左括号可以使用
3、产生右分支的时候，还受到左分支的限制，右边剩余括号的数量一定得严格大于左边剩余的数量的时候，才可以产生分支。
4、在左边和右边剩余括号数量都为0时，结束。
 */
public class Solution {
    //做减法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //特判
        if (n == 0) return res;
        //深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     **/
    private void dfs(String curStr, int left, int right, List<String> res) {
        //因为每一次尝试，都使用新的字符串变量，所以无需回溯
        //在递归终止的时候,直接添加到结果集
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        //剪枝,左括号可以使用个数严格大于右括号可以使用个数
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
