package leetcode.剑指offer;

/**
 * @author 张点
 * @description 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @date 2020/11/16 11:40
 **/
/*
思路：中序遍历二叉搜索树即可实现排序
 */
public class JZ36_Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);//中序遍历
        head.left = pre;//补上链表尾部
        pre.right = head;//补上链表头部
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        //当tail不存在时，也就是root此时在二叉搜索树的最左边节点。这个节点就是head
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        dfs(cur.right);
    }
}
