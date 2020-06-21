package 排序与搜索.二叉树的最大深度;

import 排序与搜索.TreeNode;

/*
题目描述：给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 */
public class Solution {
    public int maxDepth(TreeNode root){
        //递归法
        if(root==null){
            return 0;
        }else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height,right_height)+1;
        }

    }
}
