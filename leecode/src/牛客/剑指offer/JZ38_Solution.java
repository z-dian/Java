package 牛客.剑指offer;

/**
 * @author 张点
 * @description 二叉树的深度
 * @date 2020/9/10 15:14
 **/
public class JZ38_Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int deepleft = 1;
        int deepright = 1;
        deepleft=1+TreeDepth(root.left);
        deepright=1+TreeDepth(root.right);
        return deepleft>deepright?deepleft:deepright;
    }
}
