package 数组与字符串.实现Trie;

import 排序与搜索.TreeNode;

import java.util.HashMap;

/*实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
        示例:
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
        */
public class Trie {
    public class TrieNode {
        public int path;//表示当前节点所能链接到其他节点的个数
        public int end;//表示以当前节点为结尾的单词个数
        public HashMap<Character, TrieNode> next;//表示当前节点所能链接到的所有节点

        public TrieNode() {
            path = 0;
            end = 0;
            next = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //插入
    /*如链表生成过程一样，从根节点开始，如果根节点所链接的节点中没有当前字符，则生成一个值为当前字符的新节点，插入其中；
    如果有当前字符，则继续进行匹配，并在过程中对每一个匹配到的节点path进行计数，重复上述过程，知道插完最后一个字符，并在
    最后一个字符的节点end进行计数，表示已经将该单词的插入操作已经完成。
    */
    public void insert(String word) {
        if (word == null || word.equals("")) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) {
                node.next.put(ch, new TrieNode());
            }
            node = node.next.get(ch);
            node.path++;
        }
        node.end++;
    }

    //查找
    /*同insert操作基本相同，由于我这里使用的是HashMap进行的节点存储，故如果在匹配的过程中没能匹配到，则表示搜索失败，匹配到后最后
    一个字符时，如果当前end值不为零，则表示匹配成功。
    */

    public boolean search(String word) {
        if (word == null || word.equals("")) {
            return false;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        if (node.end == 0) return false;
        return true;
    }

    //startWith
    public boolean startsWith(String word) {
        if (word == null || word.equals("")) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        return true;

    }


}
