package 排序与搜索.二叉树的最近公共祖先;

import 排序与搜索.TreeNode;

/*
题目描述：
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root即为祖先
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonAncestor = lowestCommonAncestor(root.right, p, q);
        //如果不在左子树，那么就在右子树
        if (leftCommonAncestor == null) {
            return rightCommonAncestor;
        }
        //如果不在右子树，那么就在左子树
        if (rightCommonAncestor == null) {
            return leftCommonAncestor;
        }
        //既不在左子树，也不在右子树，那么一定就是根节点。
        return root;
    }
}
