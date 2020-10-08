package 牛客.剑指offer;

/**
 * @author 张点
 * @description 平衡二叉树
 * @date 2020/9/10 19:01
 **/
public class JZ39_Solution {
    boolean res = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        getDeepth(root);
        return res;
    }

    private int getDeepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!res) return 0;
        int left = getDeepth(root.left);
        int right = getDeepth(root.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
    }
}
