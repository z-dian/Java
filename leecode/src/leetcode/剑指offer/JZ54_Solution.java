package leetcode.剑指offer;

import java.util.Stack;

/**
 * @author 张点
 * @description 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 本文解法基于此性质：二叉搜索树的中序遍历为 递增序列。
 * 根据以上性质，易得二叉搜索树的 中序遍历倒序为 递减序列 。
 * 因此，求 “二叉搜索树第 k 大的节点” 可转化为求 “此树的中序遍历倒序的第 k 个节点”。
 * @date 2020/12/3 10:26
 **/
public class JZ54_Solution {
    /*int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }*/


}
