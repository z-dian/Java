package 牛客.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author 张点
 * @description 按之字形顺序打印二叉树
 * @date 2020/10/7 11:46
 **/
public class JZ_59Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) return list;
        //奇数层结点
        Stack<TreeNode> s1 = new Stack<>();
        //偶数层结点
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);
        int layer = 1;
        TreeNode node;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (layer % 2 == 1) {
                while (!s1.isEmpty()) {
                    node = s1.pop();
                    temp.add(node.val);
                    if (node.left != null) {
                        s2.push(node.left);
                    }
                    if (node.right != null) {
                        s2.push(node.right);
                    }
                }
            } else {
                while (!s2.isEmpty()) {
                    node = s2.pop();
                    temp.add(node.val);
                    if (node.right != null) {
                        s1.push(node.right);
                    }
                    if (node.left != null) {
                        s1.push(node.left);
                    }
                }
            }
            layer++;
            list.add(temp);
        }
        return list;
    }
}
