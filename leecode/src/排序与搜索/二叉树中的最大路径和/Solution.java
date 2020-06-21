package 排序与搜索.二叉树中的最大路径和;

import 排序与搜索.TreeNode;

/*
题目描述：
给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
思路：
初始化 max_sum 为最小可能的整数并调用函数 max_gain(node = root)。

实现 max_gain(node) 检查是继续旧路径还是开始新路径：

(1)边界情况：如果节点为空，那么最大权值是 0 。
(2)对该节点的所有孩子递归调用 max_gain，计算从左右子树的最大权值：
    left_gain = max(max_gain(node.left), 0) 和 right_gain = max(max_gain(node.right), 0)。
(3)检查是维护旧路径还是创建新路径。创建新路径的权值是：price_newpath = node.val + left_gain + right_gain，
    当新路径更好的时候更新 max_sum。
(4)对于递归返回的到当前节点的一条最大路径，计算结果为：node.val + max(left_gain, right_gain)。

 */
public class Solution {
    int max_sum=Integer.MIN_VALUE;
    public int max_gain(TreeNode node){
        if(node==null)return 0;
        //遍历左右子树，找最大值
        int left_gain=Math.max(max_gain(node.left),0);
        int right_gain=Math.max(max_gain(node.right),0);
        //计算新路径的代价
        int price_newpath = node.val+left_gain+right_gain;

        max_sum=Math.max(max_sum,price_newpath);
        //递归
        //返回最大路径的值
        return node.val+Math.max(left_gain,right_gain);
    }
    public int maxPathSum(TreeNode root){
        max_gain(root);
        return max_sum;
    }
}
