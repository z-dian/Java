package leetcode.剑指offer;

/**
 * Description: 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * Created by zhang on 2021/1/11 20:00
 */
public class JZ68_1_Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        p,q,root的关系有以下3种：
        1.p,q在root的子树中，且分列root两侧
        2.p=root,且q在root的左或右子树
        3.q=root,且p在root的左或右子树
        本题给定了两个重要条件：1、树为 二叉搜索树 ，2、树的所有节点的值都是 唯一 的。
        根据以上条件，可方便地判断 p,q 与 root 的子树关系，即：
        若 root.val < p.val ，则 p 在 root 右子树 中；
        若 root.val > p.val，则 p 在 root 左子树 中；
        若 root.val = p.val ，则 p 和 root 指向 同一节点 。
         */
        while (root != null) {
            //p,q都在root的右子树
            if (root.val < p.val && root.val < q.val) {
                root = root.right;//遍历至右子节点
            } else if (root.val > p.val && root.val > q.val) {//p,q都在root的左子树
                root = root.left;//遍历至左子节点
            } else break;
        }
        return root;
    }
}
