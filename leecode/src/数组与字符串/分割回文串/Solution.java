package 数组与字符串.分割回文串;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。
示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
思路：搜索问题主要使用回溯
1、画递归树
2、根据自己画的递归树编码
思考如何根据这递归树编码：
1、每个节点表示剩余没有扫描到的字符，产生分支是截取后剩余字符串的前缀
2、产生前缀字符串的时候判断前缀字符串是否回文
    ·如果前缀字符串是回文，那么可以产生分支和结点
    ·如果不是，则不产生分支和结点，进行剪枝操作
3、在叶子结点是空字符串的时候，此时从根结点到叶子结点的路径，就是结果集里的一个结果，如果使用深度优先遍历
记录下所有可能的结果
    ·采用一个路径遍历path搜索，path全局使用一个（注意结算的时候，要生成拷贝），因此在递归方法执行结束后需要回溯
    即将递归之前添加进来的元素拿出去
    ·path的操作只在列表的末端，因此合适的数据结构是栈。
 */
public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, stack, res);
        return res;
    }
    private void backtracking(String s ,int start,int len,Deque<String> path,List<List<String>> res){
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {

            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝
            if (!checkPalindrome(s, start, i)) {
                continue;
            }

            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.removeLast();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划先把回文子串的结果记录在一个表格里
     *
     * @param str
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
