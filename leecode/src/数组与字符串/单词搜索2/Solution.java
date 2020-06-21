package 数组与字符串.单词搜索2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
示例:
输入:
words = ["oath","pea","eat","rain"]
board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]

思路：前缀树+回溯
 */

//前缀树结构定义
class TrieNode {
    String word = null;
    //记录每一个儿子对应的下一个node是什么
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode() {
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            //看这个前缀树当前节点的孩子节点有没有该字母存在，若没有，就加进去
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));//往下走
        }
        node.word = word;
    }
}

public class Solution {

    public List<String> findWords(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();
        //构造前缀树
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        //回溯查找
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                search(board, i, j, trie.root, res);
            }
        }
        return res;
    }

    public void search(char[][] board, int i, int j, TrieNode node, List<String> res) {
        //定义查找方向
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        //如果当前节点的下一个节点不包含cur,直接return
        char cur = board[i][j];
        if (!node.children.containsKey(cur)) {
            return;
        }
        //获得当前节点
        TrieNode cur_node = node.children.get(cur);
        //当前节点已经是一个结尾了
        if (cur_node.word != null) {
            //如果结果集中没存当前节点的word，将其存入结果集
            if (!res.contains(cur_node.word)) {
                res.add(cur_node.word);
            }
        }
        //记录当前位置的character
        char tempChar = board[i][j];
        board[i][j] = 0;
        //DFS
        for (int dir = 0; dir < 4; dir++) {
            int next_x = i + dx[dir];
            int next_y = j + dy[dir];
            if (isvalid(next_x, next_y, board) == true) {
                search(board, next_x, next_y, cur_node, res);
            }
        }
        //回溯结束后放回
        board[i][j] = tempChar;
    }

    //判断是否有效（出界）
    private boolean isvalid(int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        return x >= 0 && x < m && y >= 0 && y < n && board[x][y] != 0;
    }


}
