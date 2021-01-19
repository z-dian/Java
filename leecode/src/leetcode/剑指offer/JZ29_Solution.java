package leetcode.剑指offer;
/**
 * @author 张点
 * @description 顺时针打印矩阵
 * @date 2020/11/4 9:46
 **/
public class JZ29_Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int[] res = new int[(right + 1) * (down + 1)];
        int x = 0;
        while (true) {
            //向左遍历
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[up][i];
            }
            //边界判断
            if (++up > down) break;
            //向下遍历
            for (int i = up; i <= down; i++) {
                res[x++] = matrix[i][right];
            }
            if (--right < left) break;
            //向左遍历
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[down][i];
            }
            if (--down < up) break;
            //向上遍历
            for (int i = down; i >= up; i--) {
                res[x++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return res;
    }
}
