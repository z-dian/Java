package leetcode.剑指offer;

/**
 * @author 张点
 * @description 二叉搜索树的后序遍历序列：1,3,2,6,5
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意
 * 两个数字都互不相同。
 * @date 2020/11/9 12:30
 **/
public class JZ33_Solution {
    //递归分治
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int start, int end) {
        if (start >= end-1) return true;
        int p = start;
        while (postorder[p] < postorder[end]) p++;
        int m = p;
        while (postorder[p] > postorder[end]) p++;
        return p == end && recur(postorder, start, m - 1) && recur(postorder, m, end - 1);
    }
}
