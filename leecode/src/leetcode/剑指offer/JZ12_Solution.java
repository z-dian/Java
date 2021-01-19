package leetcode.剑指offer;

/**
 * @author 张点
 * @description 矩阵中的路径
 * @date 2020/10/17 12:04
 **/
/*
思路：本问题是典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决。
算法原理：
深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
剪枝： 在搜索中，遇到 这条路不可能和目标字符串匹配成功 的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为 可行性剪枝 。

 */
public class JZ12_Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index]) return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1) return true;
        //用特殊符号标记当前字符已经访问过
        board[i][j] = '/';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j - 1, index + 1);
        //还原board[i][j]中的字符
        board[i][j] = word[index];
        return res;
    }
}
