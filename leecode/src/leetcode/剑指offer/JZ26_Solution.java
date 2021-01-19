package leetcode.剑指offer;

/**
 * @author 张点
 * @description 树的子结构问题：输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @date 2020/11/2 10:41
 **/
public class JZ26_Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //如果AB任意一个为空，返回false
        if (A == null || B == null) return false;
        //先从根节点判断B是不是A的子结构，如果不是在分别从左右两个子树判断，
        //只要有一个为true，就说明B是A的子结构
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        //这里如果B为空，说明B已经访问完了，确定是A的子结构
        if (B == null) {
            return true;
        }
        //如果B不为空A为空，或者这两个节点值不同，说明B树不是A的子结构，直接返回false
        if (A == null || A.val != B.val) {
            return false;
        }
        //当前节点比较完之后还要继续判断左右子节点
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
