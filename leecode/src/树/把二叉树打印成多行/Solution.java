package 树.把二叉树打印成多行;


import java.util.ArrayList;

/*层序遍历二叉树
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

*/
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot,1,list);
        return list;

    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root==null)return;
        if(depth>list.size()){
            list.add(new ArrayList<>());
        }
        list.get(depth-1).add(root.val);

        depth(root.left,depth+1, list);
        depth(root.right,depth+1, list);
    }

}