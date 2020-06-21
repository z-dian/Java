package 数组与字符串.单词搜索;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

 */
public class Solution {
    private boolean flag;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || board == null || word == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int cur) {
        if (cur == word.length()) {
            flag = true;
            return true;
        }
        if (NotInArea(i, j, board) || board[i][j] != word.charAt(cur)) return false;
        //如果没找到，继续dfs
        if (!flag) {
            char c = board[i][j];
            board[i][j] = '#';
            boolean res1 = dfs(board, i + 1, j, word, cur + 1);
            boolean res2 = dfs(board, i - 1, j, word, cur + 1);
            boolean res3 = dfs(board, i, j + 1, word, cur + 1);
            boolean res4 = dfs(board, i, j - 1, word, cur + 1);
            board[i][j] = c;
            return res1 || res2 || res3 || res4;
        } else {
            //找到直接结束DFS并退出，这就是剪枝
            return true;
        }
    }

    private boolean NotInArea(int i, int j, char[][] board) {
        return i < 0 || i >= board.length || j < 0 || j >= board[0].length;
    }
}
}