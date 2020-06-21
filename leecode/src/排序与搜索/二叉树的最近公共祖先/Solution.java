package 排序与搜索.二叉树的最近公共祖先;

import 排序与搜索.TreeNode;

/*
题目描述：
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
注意：
所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
示例 1:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

示例 2:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
算法：
（1）从根节点开始遍历树。
（2）如果当前节点本身是 p 或 q 中的一个，我们会将变量 mid 标记为 true，并继续搜索左右分支中的另一个节点。
（3）如果左分支或右分支中的任何一个返回 true，则表示在下面找到了两个节点中的一个。
（4）如果在遍历的任何点上，左、右或中三个标志中的任意两个变为 true，这意味着我们找到了节点 p 和 q 的最近公共祖先。

 */
public class Solution {
    public TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        //遍历到当前分支的末端，return false
        if (currentNode == null) {
            return false;
        }
        //左分支递归调用，如果当前递归返回true，则让left设为 1 ，否则设为 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        //右分支递归调用，如果当前递归返回true，则让right设为 1 ，否则设为 0
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        //如果当前节点是p或者q中的一个，就让mid值为1，否则为0
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        //如果任意两个flag值为true,就说明找到了公共祖先
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        //如果三个bool值任意一个为true，则返回true
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
