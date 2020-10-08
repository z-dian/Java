package 牛客.剑指offer;

/**
 * @author 张点
 * @description 对称的二叉树
 * @date 2020/10/6 11:45
 **/
public class JZ_58Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return isSymmetrical(l.left, r.right) && isSymmetrical(l.right, r.left);
    }
}
