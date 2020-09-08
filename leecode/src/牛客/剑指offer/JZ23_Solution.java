package 牛客.剑指offer;

/**
 * @ClassName JZ23_Solution
 * @Description 二叉搜索树的后续遍历
 * @Author 张点
 * @Date 2020/8/23 11:41
 * @Version 1.0
 **/

/**
 * 思路：
 * 后续遍历得到的序列中最后一个元素一定是树的根节点的值。数组中前面的数字可以分为两部分：左子树的值序列和右子树的值序列。
 * 左子树值都小于根节点值，右子树值都大于根节点值。
 * 确定了左子树值和右子树值的序列，还是按上面的方法确定对应的子树的结构，这是一个递归的过程。如果递归过程中发现其右子
 * 序列中有值小于根值，那么这不是一个后序序列。
 */
public class JZ23_Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        } else if (sequence.length == 1) {
            return true;
        }
        return judgePostOrder(sequence, 0, sequence.length - 1);
    }

    private boolean judgePostOrder(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = start;
        while (i <= end && sequence[i] < sequence[end]) {
            i++;
        }
        for (int j = i; j <= end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return judgePostOrder(sequence, start, i - 1) && judgePostOrder(sequence, i, end - 1);
    }
}
