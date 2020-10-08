package 牛客.剑指offer;

/**
 * @author 张点
 * @description 二叉树的下一个结点:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 * @date 2020/10/5 21:52
 **/
public class JZ_57Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        //若给定结点有右子树，则继续找右子树的最左结点
        while (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //若没有右子树，则返回父节点
        while (pNode.next != null) {
            //父节点的左结点等于本身，且本身没有右结点，那么直接返回父节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            //父节点的左节点不等于本身，说明在父节点的右子节点，继续便利父节点的父节点
            pNode = pNode.next;
        }
        return null;
    }
}
