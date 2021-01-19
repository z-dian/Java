package leetcode.剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 二叉树的最近公共祖先
 * Created by zhang on 2021/1/11 20:44
 */
public class JZ68_2_Solution {
    //后续DFS递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }
    //存储父节点
    /*
    1.先遍历二叉树，用哈希表记录每个节点的父节点指针
    2.从p节点不断往父节点指针移动，用set表记录已经访问过的祖先节点
    3.然后让q节点同样向父节点指针移动，若set记录中该祖先节点已经被访问过，那么该节点就是p和q的最近公共祖先
     */
    /*HashMap<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }*/
}
