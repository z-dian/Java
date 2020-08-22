package 树.按之字形顺序打印二叉树;
/*
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序
打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

import java.util.ArrayList;
import java.util.Stack;

/*
用两个栈保存奇数层和偶数层的节点
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();//保存奇数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();//保存偶数层节点
        if (root == null) return list;
        int layer = 1;
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp1 = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp1.add(node.val);
                        System.out.print(node.val+",");
                        if (node.left != null) {
                            s2.push(node.left);
                        }
                        if (node.right != null) {
                            s2.push(node.right);
                        }
                    }
                }
                if (!temp1.isEmpty()) {
                    list.add(temp1);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp2 = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp2.add(node.val);
                        System.out.print(node.val+",");
                        if (node.right != null) {
                            s1.push(node.right);
                        }
                        if (node.left != null) {
                            s1.push(node.left);
                        }
                    }
                }
                if(!temp2.isEmpty()){
                    list.add(temp2);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }
}
