package 排序与搜索.二叉搜索树中第K小的元素;

import 排序与搜索.TreeNode;

/*
题目描述：
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
思路：问题实质可转化为二叉搜索树中序遍历的第k的节点。
 */
public class Solution {
    /*int num = 0;//记录中序遍历的第几个元素
    int res;

    //递归法
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return res;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, k);
        num++;
        if (num == k) {
            res = node.val;
            return;
        }
        inorderTraversal(node.right,k);
    }*/

    /*中序遍历：记当前遍历的节点为 cur。
    1、cur.left 为 null，保存 cur 的值，更新 cur = cur.right
    2、cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last
    2.1 last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
    2.2 last.right 不为 null，说明之前已经访问过，第二次来到这里，表明当前子树遍历完成，
        保存 cur 的值，更新 cur = cur.right
    */
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        int num = 0;
        int res = -1;
        while (cur != null) {
            //情况1:
            if (cur.left == null) {
                num++;
                if (num == k) {
                    res = cur.val;
                    break;
                }
                cur = cur.right;
            } else {
                //情况2：找左子树最右边的节点
                //cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last
                TreeNode last = cur.left;
                while (last.right != null && last.right != cur) {
                    last = last.right;
                }
                //情况2.1：last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
                if (last.right == null) {
                    last.right = cur;
                    cur = cur.left;
                }
                //情况2.2：last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
                if (last.right == cur) {
                    last.right = null;//这里可以恢复为null
                    num++;
                    if (num == k) {
                        res = cur.val;
                        break;
                    }
                    cur = cur.right;
                }
            }

        }
        return res;
    }
}
