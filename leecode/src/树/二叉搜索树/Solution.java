package 树.二叉搜索树;

import java.util.Stack;

/*
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
//递归中序遍历
/*
public class Solution {
    //计数器
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
       if(pRoot!=null) {
           TreeNode node = KthNode(pRoot.left, k);
           if (node != null) {
               return node;
           }
           count++;
           if (count == k) {
               return pRoot;
           }
           node = KthNode(pRoot.right, k);
           if (node != null) {
               return node;
           }
       }
        return null;
    }
}
*/
public class Solution {
    //非递归中序遍历
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null||k<=0){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = pRoot;
        while (node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                count++;
                if(count==k){
                    return node;
                }
                node=node.right;
            }
        }
        return null;
    }
}
