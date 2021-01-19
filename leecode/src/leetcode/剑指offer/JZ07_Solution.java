package leetcode.剑指offer;

import 牛客.剑指offer.JZ4_Solution;

/**
 * @author 张点
 * @description 重建二叉树  输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @date 2020/10/12 12:13
 **/
public class JZ07_Solution {
    private int inp = 0; // 中根序 指针
    private int prep = 0; // 先根序 指针

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createSonTree(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode createSonTree(int[] preorder, int[] inorder, int stop) {
        /*
            先根序 用于 判断 当前根元素
            因此，只需 不超过数组长度
         */
        if (prep >= preorder.length) {
            return null;
        }

        /*
            中根序 用于 判断 当前根的 左右子树，
            因此，
                1、左子树：只需 不超过 父根
                2、右子树：无要求
         */
        if (inorder[inp] == stop) {
            inp++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[prep++]);
        node.left = createSonTree(preorder, inorder, node.val);
        node.right = createSonTree(preorder, inorder, stop);
        return node;
    }
}

