package 牛客.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JZ26_Solution
 * @Description 二叉搜索树与双向链表
 * @Author 张点
 * @Date 2020/8/26 14:22
 * @Version 1.0
 **/

/*//方法一：
public class JZ26_Solution {
    *//*
1.明确Convert函数的功能。
输入：输入一个二叉搜索树的根节点。
过程：将其转化为一个有序的双向链表。
输出：返回该链表的头节点。

2.明确成员变量pLast的功能。
pLast用于记录当前链表的末尾节点。

3.明确递归过程。
递归的过程就相当于按照中序遍历，将整个树分解成了无数的小树，然后将他们分别转化成了一小段一小段的双向链表。
再利用pLast记录总的链表的末尾，然后将这些小段链表一个接一个地加到末尾。
 *//*
    TreeNode pLast = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        //如果左子树为空，那么根节点为双向链表的头结点
        TreeNode head = Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
        }

        //连接当前节点pRootOfTree和当前链表的尾结点pLast
        pRootOfTree.left = pLast;
        if (pLast != null) {
            pLast.right = pRootOfTree;
        }
        pLast = pRootOfTree;

        Convert(pRootOfTree.right);

        return head;
    }
}*/
    //方法二
public class JZ26_Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)return null;
        List<TreeNode> tmpList = new ArrayList<>();
        //中序遍历，将二叉搜索树存入list集合中，然后再对集合中的元素进行建链表处理
        inOder(pRootOfTree,tmpList);
        TreeNode head = tmpList.get(0);
        //ptr指向当前节点
        TreeNode ptr = head;
        //第一个节点左边为空
        ptr.left=null;
        //第一个节点已经取出，从第二个节点开始连边
        for(int i = 1;i<tmpList.size();i++){
            ptr.right = tmpList.get(i);
            tmpList.get(i).left = ptr;
            ptr=ptr.right;
        }
        return head;
    }

    //中序遍历，将二叉搜索树存入list集合中
    private void inOder(TreeNode pRootOfTree, List<TreeNode> tmpList) {
        if(pRootOfTree==null)return;
        inOder(pRootOfTree.left,tmpList);
        tmpList.add(pRootOfTree);
        inOder(pRootOfTree.right,tmpList);
    }
}
