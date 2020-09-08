package 牛客.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName JZ22_Solution
 * @Description 从上往下打印二叉树
 * @Author 张点
 * @Date 2020/8/23 10:30
 * @Version 1.0
 **/
public class JZ22_Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            res.add(temp.val);
        }
        return res;
    }
}
