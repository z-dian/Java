package 牛客.剑指offer;

/**
 * @ClassName JZ4_Solution
 * @Description 重建二叉树
 * @Author 张点
 * @Date 2020/8/7 21:47
 * @Version 1.0
 **/

public class JZ4_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConBTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConBTree(int[] pre, int preleft, int preright, int[] in, int inleft, int inright) {
        //到达边界时返回null
        if (preleft > preright || inleft > inright) return null;
        //新建一个TreeNode作为根节点
        TreeNode root = new TreeNode(pre[preleft]);
        //对中序数组进行输入边界的遍历
        for (int i = inleft; i <= inright; i++) {
            if (pre[preleft] == in[i]) {
                //重构左子树
                root.left = reConBTree(pre, preleft + 1, preleft - inleft + i, in, inleft, i - 1);
                root.right = reConBTree(pre, preleft - inleft + i + 1, preright, in, i + 1, inright);
            }
        }
        return root;
    }
}
