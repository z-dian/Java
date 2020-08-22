package 牛客.剑指offer;

/**
 * @ClassName JZ18_Solution
 * @Description 镜像二叉树
 * @Author 张点
 * @Date 2020/8/18 15:45
 * @Version 1.0
 **/
public class JZ18_Solution {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
