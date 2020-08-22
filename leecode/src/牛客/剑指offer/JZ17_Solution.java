package 牛客.剑指offer;

/**
 * @ClassName JZ17_Solution
 * @Description 树的子结构
 * @Author 张点
 * @Date 2020/8/18 14:55
 * @Version 1.0
 **/
public class JZ17_Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean res = false;
        //找到树A中跟B的根节点值一样的节点R
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                res = isPartTree(root1,root2);
            }
            if(!res){
                res = HasSubtree(root1.left,root2);
            }
            if(!res){
                res = HasSubtree(root1.right,root2);
            }
        }
        return res;
    }

    //判断树A中以R节点为根节点的子树是不是和B有一样的结构（判断是不是为空，避免了视图访问空指针而造成程序崩溃，
    // 同时也设置了递归调用的退出条件）
    private boolean isPartTree(TreeNode root1, TreeNode root2) {
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isPartTree(root1.left,root2.left)&&isPartTree(root1.right,root2.right);
    }
}
