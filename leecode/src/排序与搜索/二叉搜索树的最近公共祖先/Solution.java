package 排序与搜索.二叉搜索树的最近公共祖先;

import 排序与搜索.TreeNode;

/*
题目描述：
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
思路：
(1)二叉树本身为空，root == null ，return root
(2)p.val == q.val ,一个节点也可以是它自己的祖先
(3)p.val 和 q.val 都小于 root.val
      (两个子节点的值都小于根节点的值，说明它们的公共节点只能在二叉树的左子树寻找）
(4)p.val 和 q.val 都大于 root.val
      (两个子节点的值都大于根节点的值，说明它们的公共节点只能在二叉树的右子树寻找）
(5)如果上述的情况皆不满足，说明其公共节点既不在左子树也不在右子树上，只能为最顶端的公共节点，return root

 */
public class Solution {
    //递归法
   /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }*/
    //非递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if (p.val<root.val && q.val<root.val){
                root=root.left;
            }else if (p.val>root.val && q.val>root.val){
                root=root.right;
            }else{
                break;
            }
        }
        return root;
    }
}
