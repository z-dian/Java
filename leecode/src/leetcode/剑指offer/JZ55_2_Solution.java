package leetcode.剑指offer;

/**
 * @author 张点
 * @description 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 * @date 2020/12/5 13:03
 **/
public class JZ55_2_Solution {
    /*public boolean isBalanced(TreeNode root) {
        //若recur(root) != -1,说明此树平衡,返回true，否则返回false
        return recur(root) != -1;
    }

    //后序遍历+剪枝
    public int recur(TreeNode root) {
        //终止条件，说明越过叶节点，因此返回树的高度0
        if (root == null) return 0;
        int left = recur(root.left);
        //当左子树返回-1时说明左子树不是平衡树，直接返回，相当于剪枝
        if (left == -1) return -1;
        int right = recur(root.right);
        //当右子树返回-1时说明右子树不是平衡树，直接返回，相当于剪枝
        if (right == -1) return -1;
        //当节点root左右子树深度差小于2时返回当前子树的深度,否则返回-1，代表此子树不是平衡树
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }*/

    //先序遍历+判断深度
    public boolean isBalanced(TreeNode root) {
        //空树是平衡二叉树
        if (root == null) return true;
        //如果root左右子树深度差小于等于1，且左右子树都为平衡树，则返回true，否则返回false
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        //返回当前子树深度
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
