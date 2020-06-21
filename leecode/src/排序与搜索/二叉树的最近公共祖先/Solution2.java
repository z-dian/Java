package 排序与搜索.二叉树的最近公共祖先;

import 排序与搜索.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/*
题目描述：
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
思路：找从根节点到 p 和 q 第一次分叉的节点就是这两个节点的公共祖先。
（1）先遍历树找到从根节点到 p 和根节点到 q 的两条路径，
（2）然后倒着遍历一条路径，然后看当前节点在不在另一条路径上，当第一次出现在另一条路径的节点的时候，
这个节点就是 p 和 q 的最近公共祖先。
注意：(该方法比较耗时)
1> 因为要倒着遍历一条路径，所以最好用 HashMap 存储每个节点的父节点。
2> 另外因为要判断路径中存不存在某个节点，就必须把路径中的所有节点存到 HashSet 中。
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root,null);
        //将遍历过程中每个节点的父节点保存起来。
        while (!parent.containsKey(p)||!parent.containsKey(q)){
            TreeNode cur = stack.pop();
            if(cur.left!=null){
                stack.push(cur.left);
                parent.put(cur.left,cur);
            }
            if(cur.right!=null){
                stack.push(cur.right);
                parent.put(cur.right,cur);
            }
        }
        HashSet<TreeNode> path = new HashSet<>();
        //倒着还原p的路径，并将每个节点存入hashSet中
        while (p!=null){
            path.add(p);
            p=parent.get(p);
        }
        //倒着遍历q的路径，看是否在p的路径中
        while (q!=null){
            if(path.contains(q)){
                break;
            }
            q=parent.get(q);
        }
        return q;
    }
}
