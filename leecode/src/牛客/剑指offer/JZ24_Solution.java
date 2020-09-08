package 牛客.剑指offer;

import java.util.ArrayList;

/**
 * @ClassName JZ24_Solution
 * @Description 二叉树中和为某一值的路径
 * @Author 张点
 * @Date 2020/8/25 14:55
 * @Version 1.0
 **/
public class JZ24_Solution {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null)return res;
        findPath(root,target);
        return res;
    }
    public void findPath(TreeNode root,int target){
        path.add(root.val);
        //已达到叶子节点 且正好加出了target
        if(root.val == target && root.left == null && root.right == null){
           //将该路径加入结果集
           //注意这里不能用res.add(path)，因为ArrayList是引用传递,保持了这一个path，下一个成功的path进来会被覆盖，
            //所以要new一个新的
            res.add(new ArrayList<>(path));
        }
        if(root.left!=null){
            findPath(root.left,target-root.val);
        }
        if(root.right!=null){
            findPath(root.right,target - root.val);
        }
        //完成一次递归后条件不满足了要回溯一次
        path.remove(path.size()-1);
    }
}
