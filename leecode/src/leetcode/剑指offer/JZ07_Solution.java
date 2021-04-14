package leetcode.剑指offer;


import java.util.HashMap;

/**
 * @author 张点
 * @description 重建二叉树  输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @date 2020/10/12 12:13
 **/
public class JZ07_Solution {
    //用于存储中序数组中的值以及其坐标，方便后面直接找到当前根节点的坐标
    HashMap<Integer, Integer> dic = new HashMap<>();
    //保留的先序遍历，方便递归时依据索引查看先序遍历的值
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root     当前根节点在先序数组中的索引
     * @param in_left  当前递归的左边界
     * @param in_right 当前递归的有边界
     * @return
     */
    private TreeNode recur(int root, int in_left, int in_right) {
        if (in_left > in_right) return null;//递归终止条件
        TreeNode node = new TreeNode(preorder[root]);//建立根节点
        int in_root = dic.get(preorder[root]);//获取中序数组中根节点索引
        //左子树的根的索引为先序中的根节点+1
        //递归左子树的左边界为原来的中序in_left
        //递归右子树的右边界为中序中的根节点索引-1
        node.left = recur(root + 1, in_left, in_root - 1);//递归建立左子树
        //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        //递归右子树的左边界为中序中当前根节点+1
        //递归右子树的有边界为中序中原来右子树的边界
        node.right = recur(root + in_root - in_left + 1, in_root + 1, in_right);//递归建立右子树
        //回溯返回根节点
        return node;
    }
}

