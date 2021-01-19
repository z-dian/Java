package leetcode.剑指offer;

import java.util.*;

/**
 * @author 张点
 * @description 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @date 2020/12/4 10:26
 **/
public class JZ55_1_Solution {
    //后续遍历
    /*public int maxDepth(TreeNode root) {
        //1.递归终止条件：当root==null说明已越过叶节点，返回深度0
        if (root == null) return 0;
        //2.递归过程：本质上是对左右子树进行后续遍历
        //计算节点 root 的 左子树的深度 ，即调用 maxDepth(root.left)；
        //计算节点 root 的 右子树的深度 ，即调用 maxDepth(root.right)；
        //3.返回值：返回此树的深度，即max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }*/


    //层序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            queue = temp;
            deep++;
        }
        return deep;
    }

}