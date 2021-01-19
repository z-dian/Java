package leetcode.剑指offer;

/**
 * @author 张点
 * @description 对称二叉树  节点值相等，左子树的左结点要和右子树的右节点对称，左子树的右节点要和右子树的左结点对称。
 * @date 2020/11/3 10:38
 **/
public class JZ28_Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //从两个子节点开始判断
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        //如果左右子节点都为空，说明当前节点是叶子节点，返回true
        if (left == null && right == null) {
            return true;
        }
        //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
